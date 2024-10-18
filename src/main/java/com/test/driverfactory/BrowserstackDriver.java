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
		capabilities.setCapability("browserName", config.browserName());
		bstackOptions.put("os", config.os());
		bstackOptions.put("userName", config.userName());
		bstackOptions.put("accessKey", config.accessKey());
		bstackOptions.put("osVersion", config.osVersion());
		bstackOptions.put("browserVersion", config.browserVersion());
		bstackOptions.put("consoleLogs", config.consoleLogs());
		bstackOptions.put("seleniumVersion", config.seleniumVersion());
		capabilities.setCapability("bstack:options", bstackOptions);
		try {
			driver = new RemoteWebDriver(new URL(config.remoteURL()), capabilities);
		} catch (MalformedURLException e) {
			throw new DriverInitalizationException("Driver could not be launched: " + e.getMessage(), e.getCause());
		}

		return driver;
	}

}
