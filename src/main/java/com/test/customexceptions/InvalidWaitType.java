package com.test.customexceptions;

public class InvalidWaitType extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1507191477328045902L;

	public InvalidWaitType(String message) {
		super(message);
	}

	public InvalidWaitType(String message, Throwable cause) {
		super(message, cause);
	}

}
