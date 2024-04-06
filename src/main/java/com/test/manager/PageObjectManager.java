package com.test.manager;

import org.openqa.selenium.WebDriver;

import com.test.pompages.TestPage;

public final class PageObjectManager {

	private WebDriver driver;
	private TestPage testPage;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}

	public TestPage getTestPage() {
		if (testPage == null) {
			testPage = new TestPage(driver);
		}
		return testPage;
	}

}
