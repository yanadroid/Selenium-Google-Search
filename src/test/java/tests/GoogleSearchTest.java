package tests;

import cucumber.api.CucumberOptions;
import runner.AbstractTestNGCucumberParallelTests;

@CucumberOptions(
        features = "classpath:features/GoogleSearch.feature", glue = "definitions",
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true)
public class GoogleSearchTest extends AbstractTestNGCucumberParallelTests { }
