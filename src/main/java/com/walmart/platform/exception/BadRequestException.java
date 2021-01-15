package com.walmart.platform.exception;

import org.springframework.validation.Errors;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {

	private Errors errors;

	public BadRequestException(Errors errors) {
		super("Bad request");
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

}
