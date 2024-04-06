package com.test.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
				glue = {"com.test.stepdef","com.test.hooks"},
						plugin= {"pretty",
								"html:target/html-report.html",
								"json:target/json-report.json",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"rerun:target/failedrerun.txt"},
						dryRun = false,
						tags = "@dataTable"
		)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
