package com.sbpsystems.art2d2.vizsgaremek.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAllExceptions(Exception exception) {
		Map<String, String> errors = new HashMap<>();
		errors.put("message", exception.getMessage());
		return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleAllOtherErrors(Exception exception) {
		System.out.println("CATCHED");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.contentType(MediaType.APPLICATION_JSON)
			.body(new ErrorResponse(exception.getMessage()));

	}*/

}


