package com.test.constants;

import java.io.File;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final int PAGETIMEOUT = 40;
	private static final int EXPLICITTIMEOUT = 40;
	private static final String TESTRESOURCESPATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator;
	private static final String MAINRESOURCESPATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "main" + File.separator + "resources" + File.separator;
	private static final String ENVCONFIGFILEPATH = TESTRESOURCESPATH + File.separator + "config" + File.separator
			+ "envconfig.properties";

	public static int getPagetimeout() {
		return PAGETIMEOUT;
	}

	public static int getExplicittimeout() {
		return EXPLICITTIMEOUT;
	}

	public static String getTestresourcespath() {
		return TESTRESOURCESPATH;
	}

	public static String getMainresourcespath() {
		return MAINRESOURCESPATH;
	}

	public static String getEnvconfigfilepath() {
		return ENVCONFIGFILEPATH;
	}

}
