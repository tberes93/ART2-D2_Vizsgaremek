package com.sbpsystems.art2d2.vizsgaremek.model.repository;

import com.sbpsystems.art2d2.vizsgaremek.model.entity.EyeExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EyeExerciseRepository extends JpaRepository<EyeExercise, Long> {

	List<EyeExercise> findAllByEyePracticeIdOrderByOrderNumberAsc(Long eyePracticeId);

}
