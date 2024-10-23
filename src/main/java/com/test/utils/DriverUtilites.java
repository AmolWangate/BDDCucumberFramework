package com.test.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.test.driverfactory.DriverManager;
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

	public static void clearText(WebElement element, WaitType waitType, String elementName) {
		WebElement element2 = WaitUtility.performExplicitWait(element, waitType);
		element2.clear();
		LOG.info("Cleared text from" + elementName);
	}

	public static boolean isElementDisplayed(WebElement element, WaitType waitType, String elementName) {
		boolean isDisplayed = false;
		try {
			WaitUtility.performExplicitWait(element, waitType);
			isDisplayed = true;
		} catch (Exception e) {
			isDisplayed = false;
		}
		LOG.info("is " + elementName + " displayed: " + isDisplayed);
		return isDisplayed;
	}

	public static void JSClick(WebElement element, WaitType waitType, String elementName) {
		WaitUtility.performExplicitWait(element, waitType);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();", element);
		LOG.info(elementName + " is clicked using java script executor");
	}

	public static void moveToElementAndClick(WebElement element, WaitType waitType, String elementName) {
		WebElement webElement = WaitUtility.performExplicitWait(element, waitType);
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(webElement).click().perform();
		LOG.info("moved to element " + elementName + " and clicked");
	}

	public static void getAttribute(WebElement element, WaitType waitType, String attributeName, String elementName) {
		WebElement webElement = WaitUtility.performExplicitWait(element, waitType);
		String value = webElement.getAttribute(attributeName);
		LOG.info(elementName + "attribute" + attributeName + "value is: " + value);
	}

	public static void selectDropDownValueByText(WebElement element, WaitType waitType, String dropDownName, String dropdownTextValue) {
		WebElement webElement = WaitUtility.performExplicitWait(element, waitType);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropdownTextValue);
		LOG.info("Selected" + dropdownTextValue + " from " + dropDownName);
	}

	public static void selectDropDownValueByIndex(WebElement element, WaitType waitType, String dropDownName, int index) {
		WebElement webElement = WaitUtility.performExplicitWait(element, waitType);
		Select select = new Select(webElement);
		select.selectByIndex(index);
		LOG.info("Selected" + index + " from " + dropDownName);
	}

	public static void selectDropDownValueByValue(WebElement element, WaitType waitType, String dropDownName, String value) {
		WebElement webElement = WaitUtility.performExplicitWait(element, waitType);
		Select select = new Select(webElement);
		select.selectByValue(value);
		LOG.info("Selected" + value + " from " + dropDownName);
	}

	public static void scrollToElement(WebElement element, String elementName) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		LOG.info("scrolled to" + elementName);
	}

	public static void scrollUpBy(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollBy(0, arguments[0]);", pixel);
		LOG.info("scrolled up by" + pixel + " pixel");
	}

	public static void scrollDownBy(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollBy(0, arguments[0]);", -pixel);
		LOG.info("scrolled down by" + pixel + " pixel");
	}

	public static void scrollrightBy(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollBy(arguments[0], 0);", pixel);
		LOG.info("scrolled right by" + pixel + " pixel");
	}

	public static void scrollLeftBy(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollBy(arguments[0], 0);", -pixel);
		LOG.info("scrolled left by" + pixel + " pixel");
	}

	public static void scrollToRight() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
		LOG.info("scrolled to extreme right");
	}

	public static void scrollToLeft() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollTo(0, 0);");
		LOG.info("scrolled to extreme left");
	}

	public static void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		LOG.info("scrolled to the bottom of the page");
	}

	public static void scrollToTOp() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollTo(0, 0);");
		LOG.info("scrolled to the top of the page");
	}
}
