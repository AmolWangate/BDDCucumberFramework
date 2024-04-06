package com.test.manager;

import com.test.driverfactory.DriverManager;

public class TestContextManager {
	
	public PageObjectManager pageManager;
	public TestContextManager() {
		pageManager=new PageObjectManager(DriverManager.getDriver());
	}

}
