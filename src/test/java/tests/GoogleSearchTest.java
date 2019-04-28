package tests;

import cucumber.api.CucumberOptions;
import runner.AbstractTestNGCucumberParallelTests;

@CucumberOptions(features = "classpath:features/GoogleSearch.feature", glue = "definitions")
public class GoogleSearchTest extends AbstractTestNGCucumberParallelTests { }
