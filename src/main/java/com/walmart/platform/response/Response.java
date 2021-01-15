/**
 * Copyright (c) 2017 by Sovos Compliance
 */
package com.walmart.platform.response;

import java.io.Serializable;
import java.util.List;


/**
 * This interface will be implemented by service responses so that they always
 * include common information in addition to the response content that's
 * specific to the service itself.
 *
 */
public interface Response extends Serializable {

    /**
     * Get the success boolean for the response
     * 
     * @return TRUE if the response is successful
     */
    boolean getSuccess();

    /**
     * Set the success boolean for the response
     * 
     * @param success The success boolean for the response.
     */
    void setSuccess(boolean success);

    /**
     * Get the status integer representation for the response
     * 
     * @return The integer representation for the status of the response.
     */
    Integer getStatus();

    /**
     * Set the integer representation for the status of the response
     * 
     * @param responseCode The response code for the status.
     */
    void setStatus(Integer responseCode);

    /**
     * Add an error response to the outer response
     * 
     * @param error An Error for the response.
     */
    void addError(ErrorResponse error);

    /**
     * Get the list of error responses from the response
     * 
     * @return The list of the errors.
     */
    List<ErrorResponse> getErrors();

    /**
     * Get the response message
     * 
     * @return The response message.
     */
    String getMessage();

    /**
     * Set the response message
     * 
     * @param message The message for the response.
     */
    void setMessage(String message);

}