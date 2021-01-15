package com.walmart.platform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.walmart.platform.exception.BadRequestException;
import com.walmart.platform.exception.PlatformException;
import com.walmart.platform.response.BaseResponse;
import com.walmart.platform.response.DataResponse;
import com.walmart.platform.response.ErrorResponse;

public abstract class BaseController {
	protected Logger logger;
	
    protected BaseController() {
    	this.logger = LoggerFactory.getLogger("base-api-service");
    }
    
    protected BaseController(String loggerName) {
    	this.logger = LoggerFactory.getLogger(loggerName);
    }
    
    protected ResponseEntity<BaseResponse> createErrorResponse(PlatformException e, HttpStatus httpStatus, String message) {
        BaseResponse response = new BaseResponse();
        response.setMessage(message);
        
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode(), e.getMessage());
        response.addError(errorResponse);
        
        response.setStatus(httpStatus.value());
        response.setSuccess(false);
        
        return new ResponseEntity<>(response, httpStatus);
    }
    
    protected ResponseEntity<BaseResponse> createSuccessResponse(Object resultData, String message) {
    	DataResponse dataResponse = new DataResponse();
    	
    	HttpStatus httpStatus = HttpStatus.OK;
		dataResponse.setMessage(message != null ? message : "Operation successful");
		dataResponse.setStatus(httpStatus.value());
		
		if(resultData != null) {
			dataResponse.setReturnData(resultData);
		}
		
		return new ResponseEntity<>(dataResponse, httpStatus);
    }
    
    protected ResponseEntity<byte[]> createSuccessByteResponse(byte[] content, HttpHeaders headers) {
	    return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }

	protected void checkRequest(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new BadRequestException(bindingResult);
		}
	}

	protected void checkRequest(Object target, Validator validator, BindingResult bindingResult) {
		checkRequest(bindingResult);
		validator.validate(target, bindingResult);
		checkRequest(bindingResult);
	}

}
