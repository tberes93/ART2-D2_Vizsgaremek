package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.LoginDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.RegistrationDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.UserDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.AppUser;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.AppUserMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.AppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Transactional
@Service
public class AuthService {

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AppUserRepository userRepository;

	@Autowired
	AppUserMapper appUserMapper;

	public UserDto authenticateUser(LoginDto loginDto){
		Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(
			loginDto.getUserName(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String userName = authentication.getName();
		AppUser user = userRepository.findByUserName(userName);

		//AppUserDetails appUserDetails = (AppUserDetails) authentication.getDetails();
		return appUserMapper.toUserDto(user);
	}

	public UserDto registerUser(@RequestBody RegistrationDto registrationDto) {
		// add check for username exists in a DB
		if (userRepository.existsByUserName(registrationDto.getUserName())){
			//return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
			throw new IllegalArgumentException("Username is already taken!");
		}

		// create user object
		AppUser user = new AppUser();
		user.setUserName(registrationDto.getUserName());
		user.setFirstName(registrationDto.getFirstName());
		user.setLastName(registrationDto.getLastName());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

		userRepository.save(user);

		return appUserMapper.toUserDto(user);
	}
}
