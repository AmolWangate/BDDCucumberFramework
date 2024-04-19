package com.test.hooks;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.test.driverfactory.DriverFactory;
import com.test.driverfactory.DriverManager;
import com.test.enums.BrowserType;
import com.test.enums.Modes;
import com.test.owner.EnvConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

	private static final Logger LOG = LogManager.getLogger();

	@Before(order = 0)
	public void setUp(Scenario sc) {
		LOG.info("Starting scenario: " + sc.getName());
		EnvConfig config = ConfigFactory.create(EnvConfig.class);
		String browser = System.getProperty("browser", config.browser());
		String mode = System.getProperty("mode", config.mode());
		DriverFactory.initDriver(Modes.valueOf(mode.toUpperCase()), BrowserType.valueOf(browser.toUpperCase()));
	}

	@After(order = 0)
	public void tearDown(Scenario sc) {
		LOG.info("Ending scenario: " + sc.getName());
		DriverFactory.quitDriver();
	}

	@After(order = 1)
	public void getScreenshot(Scenario sc) {
		if (sc.isFailed()) {
			LOG.error("getting screenshot for failed sceanrio: " + sc.getName());
			byte[] path = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			sc.attach(path, "image/png", sc.getName());
		}

	}

}
