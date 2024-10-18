package com.test.utils;

import java.util.Base64;

public final class Base64Util {
	
	private Base64Util() {
		
	}

	public static String encode(String input) {
		return Base64.getEncoder().encodeToString(input.getBytes());
	}

	public static String decode(String base64String) {
		byte[] decodedBytes = Base64.getDecoder().decode(base64String);
		return new String(decodedBytes);
	}

}
