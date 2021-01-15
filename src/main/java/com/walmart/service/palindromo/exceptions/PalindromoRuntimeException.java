package com.walmart.service.palindromo.exceptions;

@SuppressWarnings("serial")
public class PalindromoRuntimeException extends RuntimeException {
	
	/**
     * Default Constructor for PDF exception class
     */
    public PalindromoRuntimeException() {
        super();
    }

    /**
     * Constructor for PDF exception class
     * 
     * @param message Exception message
     */
    public PalindromoRuntimeException(String message) {
        super(message);
    }

    /**
     * Constructor for PDF exception class
     * 
     * @param message Exception message
     * @param cause Exception cause
     */
    public PalindromoRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor for PDF exception class
     * 
     * @param cause Exception clause
     */
    public PalindromoRuntimeException(Throwable cause) {
        super(cause);
    }

}
