package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.EyeExerciseDto;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.EyeExerciseMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.EyeExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EyeExerciseService {

	@Autowired
	private EyeExerciseRepository eyeExerciseRepository;

	@Autowired
	EyeExerciseMapper eyeExerciseMapper;

	@Autowired
	private AppUserService appUserService;

	public List<EyeExerciseDto> getAllEyeExerciseByEyePracticeId(Long eyePracticeId) {
		if (eyePracticeId == null) {
			throw new IllegalArgumentException("A szemtorna azonosító megadása kötelező!");
		}
		return eyeExerciseMapper.toEyeExerciseDtoList(eyeExerciseRepository.findAllByEyePracticeIdOrderByOrderNumberAsc(eyePracticeId));
	}


}
