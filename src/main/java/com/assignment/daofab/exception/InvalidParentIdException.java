package com.assignment.daofab.exception;

/**
 * 
 * @author Sanket Lathiya
 *
 */
public class InvalidParentIdException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidParentIdException() {
        super();
    }

    public InvalidParentIdException(String message) {
        super(message);
    }
}
