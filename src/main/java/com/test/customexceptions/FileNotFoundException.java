package com.test.customexceptions;

public class FileNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2320066725764250597L;

	public FileNotFoundException(String message) {
		super(message);
	}

	public FileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
