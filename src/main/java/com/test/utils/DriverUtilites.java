package com.test.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.test.enums.WaitType;

public final class DriverUtilites {

	private static final Logger LOG = LogManager.getLogger();

	private DriverUtilites() {

	}

	public static void click(WebElement element, WaitType waitType, String elementName) {
		WaitUtility.performExplicitWait(element, waitType).click();
		LOG.info(elementName + " is clicked");
	}

	public static void sendKeys(WebElement element, WaitType waitType, String stringToBeSent, String elementName) {
		WebElement element2 = WaitUtility.performExplicitWait(element, waitType);
		element2.clear();
		element2.sendKeys(stringToBeSent);
		LOG.info("Entered text in " + elementName + " is " + stringToBeSent);
	}

	public static String getText(WebElement element, WaitType waitType, String elementName) {
		String text = WaitUtility.performExplicitWait(element, waitType).getText();
		LOG.info(elementName + " text value is: " + text);
		return text;
	}

	public static boolean isDisplayed(WebElement element, WaitType waitType, String elementName) {
		boolean isDisplayed = WaitUtility.performExplicitWait(element, waitType).isDisplayed();
		LOG.info(elementName + " is displayed: " + isDisplayed);
		return isDisplayed;
	}

}
