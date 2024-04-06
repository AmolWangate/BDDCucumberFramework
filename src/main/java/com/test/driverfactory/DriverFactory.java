package com.test.driverfactory;

import java.time.Duration;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.constants.FrameworkConstants;
import com.test.enums.BrowserType;
import com.test.enums.Env;
import com.test.owner.EnvConfig;
import com.test.utils.PropertyReader;

public final class DriverFactory {
	
	private static Logger LOG= LogManager.getLogger();
	
	private DriverFactory() {

	}

	public static void initDriver(BrowserType browserType) {
		EnvConfig config=ConfigFactory.create(EnvConfig.class);
		String url=config.url();
		
		switch (browserType) {
		case CHROME:
			LOG.info("launching chrome driver");
			DriverManager.setDriver(new ChromeDriver());
			break;
		case FIREFOX:
			LOG.info("launching firefox driver");
			DriverManager.setDriver(new FirefoxDriver());
			break;
		case EDGE:
			LOG.info("launching edge driver");
			DriverManager.setDriver(new EdgeDriver());
			break;
		default:
			LOG.info("launching default chrome driver");
			DriverManager.setDriver(new ChromeDriver());
			break;
		}
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPagetimeout()));
//		DriverManager.getDriver().get(PropertyReader.getPropertyValue(FrameworkConstants.getEnvconfigfilepath(), Env.URL));
		DriverManager.getDriver().get(url);
	}

	public static void quitDriver() {
		LOG.info("Quitting driver");
		DriverManager.getDriver().quit();
	}
}
