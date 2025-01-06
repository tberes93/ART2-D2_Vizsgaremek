package com.sbpsystems.art2d2.vizsgaremek.service;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.EyePracticeDto;
import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.EyePracticeType;
import com.sbpsystems.art2d2.vizsgaremek.model.mapper.EyePracticeMapper;
import com.sbpsystems.art2d2.vizsgaremek.model.repository.EyePracticeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EyePracticeService {

	private static final Logger logger = LoggerFactory.getLogger(EyePracticeService.class);

	@Autowired
	private EyePracticeRepository eyePracticeRepository;

	@Autowired
	EyePracticeMapper eyePracticeMapper;

	public EyePracticeDto getPracticeByType(String type) {
		EyePracticeType eyePracticeType = EyePracticeType.getEyePracticeTypeByKod(type);
		if (eyePracticeType == null) {
			logger.error("Cannot find EyePracticeType by kod: " + type);
			return null;
		}
		return eyePracticeMapper.toEyePracticeDto(eyePracticeRepository.findByType(eyePracticeType));
	}
}
