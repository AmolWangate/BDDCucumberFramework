package com.test.constants;

import java.io.File;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final int PAGE_TIMEOUT = 40;
	private static final int EXPLICIT_TIMEOUT = 40;
	private static final String TEST_RESOURCES_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator;
	private static final String MAIN_RESOURCES_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "main" + File.separator + "resources" + File.separator;
	private static final String ENV_CONFIG_FILE_PATH = TEST_RESOURCES_PATH + File.separator + "config" + File.separator
			+ "envconfig.properties";
	private static final String REMOTE_CONFIG_FILE_PATH = TEST_RESOURCES_PATH + File.separator + "config" + File.separator
			+ "remoteconfig.properties";

	public static int getPagetimeout() {
		return PAGE_TIMEOUT;
	}

	public static int getExplicittimeout() {
		return EXPLICIT_TIMEOUT;
	}

	public static String getTestresourcespath() {
		return TEST_RESOURCES_PATH;
	}

	public static String getMainresourcespath() {
		return MAIN_RESOURCES_PATH;
	}

	public static String getEnvconfigfilepath() {
		return ENV_CONFIG_FILE_PATH;
	}

	public static String getRemoteConfigFilePath() {
		return REMOTE_CONFIG_FILE_PATH;
	}

}
