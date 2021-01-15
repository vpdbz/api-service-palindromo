/**
 * Copyright (c) 2017 by Sovos Compliance
 */
package com.walmart.platform.exception;

/**
 * Sovos Platform Sevices common code wrapped exception class.
 */
public class PlatformException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorCode = "";
    
    /**
     * Default Constructor for Platform Services exception class
     */
    public PlatformException() {
        super();
    }

    /**
     * Constructor for Platform Services exception class
     * 
     * @param message Exception message
     */
    public PlatformException(String message) {
        super(message);
    }

    /**
     * Constructor for Platform Services exception class
     * 
     * @param message Exception message
     * @param cause Exception cause
     */
    public PlatformException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor for Platform Services exception class
     * 
     * @param cause Exception clause
     */
    public PlatformException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Constructor for Platform Services exception class
     * 
     * @param message Exception message
     * @param code the code of the exception
     */
    public PlatformException(String message, String code) {
        super(message);
        this.setErrorCode(code);
    }

    /**
     * Constructor for Platform Services exception class
     * 
     * @param message Exception message
     * @param cause Exception cause
     * @param code the code of the exception
     */
    public PlatformException(String message, Throwable cause, String code) {
        super(message, cause);
        this.setErrorCode(code);
    }
    
    /**
     * Get Platform Error Code.
     * @return the error code.
     */
    public String getErrorCode(){
        return errorCode;
    }
    
    /**
     * Set Platform Error Code.
     * @param code the error code.
     */
    public void setErrorCode(String code){
        this.errorCode = code;
    }

}