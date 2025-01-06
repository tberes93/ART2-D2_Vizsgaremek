package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.RewardDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.StartExerciseDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.UserDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.AppUser;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.AppUserMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.RewardMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.AppUserRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("AppUserService Test Suite")
class AppUserServiceTest {

    @Mock
    private AppUserRepository userRepository;

    @Mock
    private AppUserMapper appUserMapper;

    @Mock
    private RewardService rewardService;

    @Mock
    private RewardMapper rewardMapper;

    @InjectMocks
    private AppUserService appUserService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    @DisplayName("getUserData Method Tests")
    class GetUserDataTests {
        @Test
        @DisplayName("Should return user data for valid userId")
        void testGetUserData(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should return user data for valid userId");
            Long userId = 1L;
            AppUser appUser = new AppUser();
            UserDto userDto = new UserDto();

            when(userRepository.findById(userId)).thenReturn(Optional.of(appUser));
            when(appUserMapper.toUserDto(appUser)).thenReturn(userDto);

            UserDto result = appUserService.getUserData(userId);

            assertNotNull(result);
            assertEquals(userDto, result);
        }
    }

    @Nested
    @DisplayName("getAppUserById Method Tests")
    class GetAppUserByIdTests {
        @Test
        @DisplayName("Should return AppUser for valid userId")
        void testGetAppUserById(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should return AppUser for valid userId");
            Long userId = 1L;
            AppUser appUser = new AppUser();

            when(userRepository.findById(userId)).thenReturn(Optional.of(appUser));

            AppUser result = appUserService.getAppUserById(userId);

            assertNotNull(result);
            assertEquals(appUser, result);
        }
    }

    @Nested
    @DisplayName("getTop10 Method Tests")
    class GetTop10Tests {
        @Test
        @DisplayName("Should return top 10 users")
        void testGetTop10(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should return top 10 users");
            appUserService.getTop10();
            verify(userRepository, times(1)).findTopUsersWithScore(PageRequest.of(0, 10));
        }
    }

    @Nested
    @DisplayName("getAllUsers Method Tests")
    class GetAllUsersTests {
        @Test
        @DisplayName("Should return all users")
        void testGetAllUsers(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should return all users");
            when(userRepository.findAll()).thenReturn(Collections.emptyList());
            when(appUserMapper.toUserDtoList(anyList())).thenReturn(Collections.emptyList());

            assertTrue(appUserService.getAllUsers().isEmpty());
        }
    }

    @Nested
    @DisplayName("getAllRewardByUser Method Tests")
    class GetAllRewardByUserTests {
        @Test
        @DisplayName("Should return all rewards for a user")
        void testGetAllRewardByUser(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should return all rewards for a user");
            Long userId = 1L;
            AppUser appUser = new AppUser();
            Set<RewardDto> rewardDtos = Collections.emptySet();

            when(userRepository.findById(userId)).thenReturn(Optional.of(appUser));
            when(rewardMapper.toRewardDtoList(appUser.getRewardSet())).thenReturn(rewardDtos);

            Set<RewardDto> result = appUserService.getAllRewardByUser(userId);

            assertNotNull(result);
            assertEquals(rewardDtos, result);
        }
    }

    @Nested
    @DisplayName("startExerciseByUser Method Tests")
    class StartExerciseByUserTests {
        @Test
        @DisplayName("Should start exercise for user")
        void testStartExerciseByUser(TestReporter testReporter) {
            testReporter.publishEntry("Running test: Should start exercise for user");
            Long userId = 1L;
            StartExerciseDto startExerciseDto = new StartExerciseDto();
            startExerciseDto.setUserId(userId);
            AppUser appUser = new AppUser();
            appUser.setLastPracticeDate(new Date(System.currentTimeMillis() - 86400000L)); // 1 day ago

            when(userRepository.findById(userId)).thenReturn(Optional.of(appUser));

            appUserService.startExerciseByUser(startExerciseDto);

            verify(userRepository, times(1)).save(appUser);
        }
    }
}
