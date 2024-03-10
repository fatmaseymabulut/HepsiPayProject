package com.HB.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "com/HB/step_definitions",
        tags = "@UI"

)
public class CukesRunner {
}


