package com.sbpsystems.art2d2.vizsgaremek.controller;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.EyeExerciseDto;
import com.sbpsystems.art2d2.vizsgaremek.service.EyeExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/art2d2/api/exercise")
public class ExerciseController {

	@Autowired
	private EyeExerciseService eyeExerciseService;

	@GetMapping("/list/{eye-practice-id}")
	public ResponseEntity<List<EyeExerciseDto>> getAllEyeExerciseByEyePracticeId(@PathVariable("eye-practice-id") Long eyePracticeId) {
		List<EyeExerciseDto> list = eyeExerciseService.getAllEyeExerciseByEyePracticeId(eyePracticeId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
