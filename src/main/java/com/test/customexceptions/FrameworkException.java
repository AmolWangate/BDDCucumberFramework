package com.test.customexceptions;

public class FrameworkException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5088758580493080860L;

	public FrameworkException(String message) {
		super(message);
	}

	public FrameworkException(String message, Throwable cause) {
		super(message, cause);
	}
}
