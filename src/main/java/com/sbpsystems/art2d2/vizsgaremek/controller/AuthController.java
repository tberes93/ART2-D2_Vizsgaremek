package com.sbpsystems.art2d2.vizsgaremek.controller;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.LoginDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.RegistrationDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.UserDto;
import com.sbpsystems.art2d2.vizsgaremek.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/art2d2/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/authenticate")
	public ResponseEntity<UserDto> authenticateUser(@RequestBody LoginDto loginDto) {
		UserDto userDto = authService.authenticateUser(loginDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody RegistrationDto registrationDto) {
		UserDto userDto = authService.registerUser(registrationDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
}
