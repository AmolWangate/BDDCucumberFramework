package com.test.customexceptions;

public class DriverInitalizationException extends FrameworkException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7268017602640809102L;

	public DriverInitalizationException(String message) {
		super(message);
	}

	public DriverInitalizationException(String message, Throwable cause) {
		super(message, cause);
	}
}
