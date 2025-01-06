package com.sbpsystems.art2d2.vizsgaremek.model.repository;

import com.sbpsystems.art2d2.vizsgaremek.model.entity.EyePractice;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.EyePracticeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EyePracticeRepository extends JpaRepository<EyePractice, Long> {

	EyePractice findByType(EyePracticeType type);
}
