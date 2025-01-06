package com.sbpsystems.art2d2.vizsgaremek.controller;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.RewardDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.StartExerciseDto;
import com.sbpsystems.art2d2.vizsgaremek.model.dto.UserDto;
import com.sbpsystems.art2d2.vizsgaremek.service.AppUserService;
import com.sbpsystems.art2d2.vizsgaremek.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/art2d2/api/user")
public class AppUserController {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private RewardService rewardService;

	@GetMapping("/userdata/{id}")
	public ResponseEntity<UserDto> getUserData(@PathVariable("id") Long userId) {
		UserDto userDto = appUserService.getUserData(userId);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@GetMapping("/top10")
	public ResponseEntity<List<UserDto>> getTop10() {
		List<UserDto> userDto = appUserService.getTop10();
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = appUserService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping("/start-exercise")
	public void startExerciseByUser(@RequestBody StartExerciseDto startExerciseDto) {
		appUserService.startExerciseByUser(startExerciseDto);
	}

	@GetMapping("/rewards/{id}")
	public ResponseEntity<Set<RewardDto>> getAllRewardsByUser(@PathVariable("id") Long userId) {
		Set<RewardDto> rewards = appUserService.getAllRewardByUser(userId);
		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}

}
