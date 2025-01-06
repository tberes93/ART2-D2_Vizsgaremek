package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.LoginDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.RegistrationDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.UserDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.AppUser;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.AppUserMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.AppUserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("AuthService Test Suite")
class AuthServiceTest {

    @Mock
    private AuthenticationProvider authenticationProvider;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AppUserRepository userRepository;

    @Mock
    private AppUserMapper appUserMapper;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    void setUp() {
        SecurityContextHolder.clearContext();
    }

    @Nested
    @DisplayName("authenticateUser Method Tests")
    class AuthenticateUserTests {
        @Test
        @DisplayName("Should authenticate user with valid credentials")
        void testAuthenticateUser(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should authenticate user with valid credentials");
            LoginDto loginDto = new LoginDto();
            loginDto.setUserName("testuser");
            loginDto.setPassword("password");

            AppUser appUser = new AppUser();
            appUser.setUserName("testuser");

            Authentication authentication = mock(Authentication.class);
            when(authenticationProvider.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                    .thenReturn(authentication);
            when(authentication.getName()).thenReturn("testuser");
            when(userRepository.findByUserName("testuser")).thenReturn(appUser);
            when(appUserMapper.toUserDto(appUser)).thenReturn(new UserDto());

            UserDto result = authService.authenticateUser(loginDto);

            assertNotNull(result);
            verify(authenticationProvider, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
            verify(userRepository, times(1)).findByUserName("testuser");
        }
    }

    @Nested
    @DisplayName("registerUser Method Tests")
    class RegisterUserTests {
        @Test
        @DisplayName("Should register user with valid data")
        void testRegisterUser(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should register user with valid data");
            RegistrationDto registrationDto = new RegistrationDto();
            registrationDto.setUserName("newuser");
            registrationDto.setFirstName("First");
            registrationDto.setLastName("Last");
            registrationDto.setPassword("password");

            AppUser appUser = new AppUser();
            appUser.setUserName("newuser");

            when(userRepository.existsByUserName("newuser")).thenReturn(false);
            when(passwordEncoder.encode("password")).thenReturn("encodedpassword");
            when(userRepository.save(any(AppUser.class))).thenReturn(appUser);
            when(appUserMapper.toUserDto(any(AppUser.class))).thenReturn(new UserDto());

            UserDto result = authService.registerUser(registrationDto);

            assertNotNull(result);
            verify(userRepository, times(1)).existsByUserName("newuser");
            verify(userRepository, times(1)).save(any(AppUser.class));
        }

        @Test
        @DisplayName("Should throw exception if username already taken")
        void testRegisterUser_UsernameTaken(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should throw exception if username already taken");
            RegistrationDto registrationDto = new RegistrationDto();
            registrationDto.setUserName("existinguser");

            when(userRepository.existsByUserName("existinguser")).thenReturn(true);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                authService.registerUser(registrationDto)
            );

            assertEquals("Username is already taken!", exception.getMessage());
            verify(userRepository, times(1)).existsByUserName("existinguser");
            verify(userRepository, never()).save(any(AppUser.class));
        }
    }
}
