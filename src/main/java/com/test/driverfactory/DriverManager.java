package com.test.driverfactory;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class DriverManager {

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

	static synchronized void unload() {
		tlDriver.remove();
	}
}
