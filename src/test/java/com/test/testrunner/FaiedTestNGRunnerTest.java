package com.test.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@reports/failedrerun.txt",
				glue = {"com.test.stepdef","com.test.hooks"},
						plugin= {"pretty",
								"html:reports/html-report",
								"json:reports/json-report.json",
								"usage:reports/usage.json",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
						dryRun = false
		)
public class FaiedTestNGRunnerTest extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
