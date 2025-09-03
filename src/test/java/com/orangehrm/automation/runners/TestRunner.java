package com.orangehrm.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",     // path to your feature files
    glue = "com.orangehrm.automation.stepdefs",   // step definitions package
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "rerun:target/failed_scenarios.txt"
    },
    monochrome = true,
    publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // No code needed – AbstractTestNGCucumberTests hooks into TestNG automatically
}
