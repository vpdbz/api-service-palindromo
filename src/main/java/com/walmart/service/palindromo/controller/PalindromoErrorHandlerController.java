package com.walmart.service.palindromo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.walmart.platform.controller.ErrorHandlerController;
import com.walmart.platform.exception.BadRequestException;
import com.walmart.platform.response.BaseResponse;
import com.walmart.service.palindromo.exceptions.PalindromoRuntimeException;

@RestControllerAdvice
public class PalindromoErrorHandlerController extends ErrorHandlerController {
	private static final Logger log = LoggerFactory.getLogger(PalindromoErrorHandlerController.class);

	@Autowired
	private MessageSource messageSource;

	@Override
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BaseResponse> badRequest(BadRequestException e, HttpServletRequest request) {
		log.error("Bad request for {}", request.getRequestURI());
		return super.badRequest(e, request);
	}

	@ExceptionHandler(PalindromoRuntimeException.class)
	public ResponseEntity<BaseResponse> pdfRuntimeException(PalindromoRuntimeException e) {
		log.error(getMessage(e.getMessage()), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createErrorResponse(getMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@Override
	protected String getMessage(String message) {
		return messageSource.getMessage(message, null, message, LocaleContextHolder.getLocale());
	}

}
