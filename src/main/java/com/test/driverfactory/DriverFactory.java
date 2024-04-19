package com.test.driverfactory;

import java.time.Duration;
import java.util.Objects;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.test.constants.FrameworkConstants;
import com.test.enums.BrowserType;
import com.test.enums.Modes;
import com.test.owner.EnvConfig;

public final class DriverFactory {

	private static Logger LOG = LogManager.getLogger();

	private DriverFactory() {

	}

	public static void initDriver(Modes modes, BrowserType browserType) {
		if (Objects.isNull(DriverManager.getDriver())) {
			if (modes.equals(Modes.LOCAL)) {
				LOG.info("launching local driver");
				DriverManager.setDriver(new LocalDriver().getDriver(browserType));
			} else if (modes.equals(Modes.BROWSERSTACK)) {
				LOG.info("launching browserstack driver");
				DriverManager.setDriver(new BrowserstackDriver().getDriver(browserType));
			}

			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().timeouts()
					.pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPagetimeout()));
			DriverManager.getDriver().get(ConfigFactory.create(EnvConfig.class).url());
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			LOG.info("Quitting driver");
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}