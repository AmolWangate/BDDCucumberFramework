package com.test.driverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.enums.BrowserType;

public class LocalDriver implements IDriver {

	private static final Logger LOG = LogManager.getLogger();

	@Override
	public WebDriver getDriver(BrowserType browserType) {
		WebDriver driver = null;
		switch (browserType) {
		case CHROME:
			LOG.info("launching chrome driver");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			LOG.info("launching firefox driver");
			driver = new FirefoxDriver();
			break;
		case EDGE:
			LOG.info("launching edge driver");
			driver = new EdgeDriver();
			break;
		default:
			LOG.info("launching default chrome driver");
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}

}
