/**
 * Copyright (c) 2017 by Sovos Compliance
 */
package com.walmart.platform.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Implements functionality from Response interface for all items that will
 * appear in every JSON response.
 *
 */
public class BaseResponse implements Response, Serializable {

    private static final long serialVersionUID = -3086475621942934987L;

    protected boolean isSuccessful = true;

    protected Integer status = 200;

    protected List<ErrorResponse> errors;

    protected String message;

    @JsonProperty
    @Override
    public boolean getSuccess() {

        return isSuccessful;
    }

    @Override
    public void setSuccess(boolean success) {

        this.isSuccessful = success;
    }

    @Override
    public Integer getStatus() {

        return status;
    }

    @Override
    public void setStatus(Integer status) {

        this.status = status;
    }

    @Override
    public String getMessage() {

        return message;
    }

    @Override
    public void setMessage(String message) {

        this.message = message;
    }

    @Override
    public void addError(ErrorResponse error) {

        if (errors == null) {
            errors = new ArrayList<ErrorResponse>();
        }
        errors.add(error);
    }

    @Override
    public List<ErrorResponse> getErrors() {

        return errors;
    }

}