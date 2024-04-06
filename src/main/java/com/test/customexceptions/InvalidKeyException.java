package com.test.customexceptions;

public class InvalidKeyException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7664385112596333649L;

	public InvalidKeyException(String message) {
		super(message);
	}

	public InvalidKeyException(String message, Throwable cause) {
		super(message, cause);
	}
}
