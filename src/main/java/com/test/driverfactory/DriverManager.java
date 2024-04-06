package com.test.driverfactory;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static Logger LOG=LogManager.getLogger();
	
	private DriverManager() {

	}

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	static synchronized void setDriver(WebDriver driver) {
		if (Objects.nonNull(driver)) {
			tlDriver.set(driver);
		}
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void unload() {
		tlDriver.remove();
	}
}
