package com.sbpsystems.art2d2.vizsgaremek.controller.advice;

public class ErrorResponse {

	private String message;

	public ErrorResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
