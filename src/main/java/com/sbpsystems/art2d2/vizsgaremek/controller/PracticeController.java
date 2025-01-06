package com.sbpsystems.art2d2.vizsgaremek.controller;

import com.sbpsystems.art2d2.vizsgaremek.model.dto.EyePracticeDto;
import com.sbpsystems.art2d2.vizsgaremek.service.EyePracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/art2d2/api/practice")
public class PracticeController {

	@Autowired
	private EyePracticeService practiceService;

	@GetMapping("/{type}")
	public ResponseEntity<EyePracticeDto> getPracticeByType(@PathVariable("type") String type) {
		EyePracticeDto practiceDto = practiceService.getPracticeByType(type);
		return new ResponseEntity<>(practiceDto, HttpStatus.OK);
	}

}
