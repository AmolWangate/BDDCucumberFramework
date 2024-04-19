package com.test.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.constants.FrameworkConstants;
import com.test.customexceptions.InvalidWaitType;
import com.test.driverfactory.DriverManager;
import com.test.enums.WaitType;

public class WaitUtility {

	private WaitUtility() {

	}

	public static WebElement performExplicitWait(WebElement element, WaitType waitType) {
		WebElement webElement = null;
		switch (waitType) {
		case CLICKABLE:
			webElement = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicittimeout()))
					.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case VISIBLE:
			webElement = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicittimeout()))
					.until(ExpectedConditions.visibilityOf(element));
			break;
		case NONE:
			webElement = element;
			break;
		default:
			throw new InvalidWaitType("Invalid wait type: " + waitType.name());
		}
		return webElement;
	}

}
