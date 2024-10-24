package com.test.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
				glue = {"com.test.stepdef","com.test.hooks"},
						plugin= {"pretty",
								 "html:reports/cucumber-reports.html",
								 "json:reports/cucumber-reports.json",
								 "usage:reports/usage.json",
								 "rerun:reports/failedrerun.txt",
								 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
						dryRun = false
//						tags = "@dataTable"
						
		)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
