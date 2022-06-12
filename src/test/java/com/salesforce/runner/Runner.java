package com.salesforce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/LoginFeature.feature"},
					glue = {"com.salesforce.steps"},
					plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"})

public class Runner extends AbstractTestNGCucumberTests{

}
