package com.walmart.platform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import com.walmart.platform.exception.BadRequestException;
import com.walmart.platform.response.BaseResponse;
import com.walmart.platform.response.ErrorResponse;

public abstract class ErrorHandlerController {

	protected ResponseEntity<BaseResponse> badRequest(BadRequestException e, HttpServletRequest request) {
		BaseResponse response = createErrorResponse("Validation Data", HttpStatus.BAD_REQUEST);

		List<FieldError> errorList = e.getErrors().getFieldErrors();
		for (FieldError item : errorList) {
			String message = getMessage(item.getDefaultMessage());
			ErrorResponse error = new ErrorResponse(item.getField(), message);
			response.addError(error);
		}

		return ResponseEntity.badRequest().body(response);
	}
	
	protected BaseResponse createErrorResponse(String message, HttpStatus httpStatus) {
        BaseResponse response = new BaseResponse();

        response.setMessage(getMessage(message));
        response.setStatus(httpStatus.value());
        response.setSuccess(false);
        
        return response;
    }
	
	protected abstract String getMessage(String message);

}
