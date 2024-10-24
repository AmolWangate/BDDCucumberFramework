package com.test.driverfactory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserCapabilities {

	 public static ChromeOptions getChromeOptions() {
	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--headless");
	        options.addArguments("--window-size=1920x1080");
	        options.addArguments("--incognito"); 
	        return options;
	    }
	 
	 public static FirefoxOptions getFirefoxOptions() {
	        FirefoxOptions options = new FirefoxOptions();
//	        options.addArguments("--headless");
//	        options.addArguments("--private");
	        return options;
	    }
}
