package com.test.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.test.customexceptions.DriverInitalizationException;
import com.test.enums.BrowserType;
import com.test.owner.EnvConfig;

public class BrowserstackDriver implements IDriver {

	@Override
	public WebDriver getDriver(BrowserType browserType) {
		WebDriver driver = null;
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<>();
		EnvConfig config = ConfigFactory.create(EnvConfig.class);
		capabilities.setCapability("browserName", config.browsername());
		bstackOptions.put("os", config.os());
		bstackOptions.put("userName", config.username());
		bstackOptions.put("accessKey", config.accesskey());
		bstackOptions.put("osVersion", config.osversion());
		bstackOptions.put("browserVersion", config.browserversion());
		bstackOptions.put("consoleLogs", config.consolelogs());
		bstackOptions.put("seleniumVersion", config.seleniumversion());
		capabilities.setCapability("bstack:options", bstackOptions);
		try {
			driver = new RemoteWebDriver(new URL(config.remoteurl()), capabilities);
		} catch (MalformedURLException e) {
			throw new DriverInitalizationException("Driver could not be launched: " + e.getMessage(), e.getCause());
		}

		return driver;
	}

}
