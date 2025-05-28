package com.qa.Hooks;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/features", 
    glue = "com.qa.steps",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports/Cucumber.json"
    },
    monochrome = true,
    tags = "@login"
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @Test
    public void runCucumber() {
        // Nothing to do...
    }

}
