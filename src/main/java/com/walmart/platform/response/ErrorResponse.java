/**
 * Copyright (c) 2017 by Sovos Compliance
 */
package com.walmart.platform.response;

import java.io.Serializable;


/**
 * This class passes back error information back to the User (e.g. validation
 * per field).
 *
 */
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subcode;
    private String message;

    /**
     * default constructor - two fields
     * 
     * @param subcode
     * @param message
     */
    public ErrorResponse(String subcode, String message) {

        this.subcode = subcode;
        this.message = message;
    }

    public String getSubcode() {

        return subcode;
    }

    public void setSubcode(String subcode) {

        this.subcode = subcode;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }
}