package com.bookcart.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/features/"}
        , dryRun = false
        , snippets = CucumberOptions.SnippetType.CAMELCASE
        , glue = {"com.bookcart.steps", "com.bookcart.hooks"}
        , plugin = {"pretty"
                ,"html:Reports/ExecutionReport.html"}
        , tags = "@Smoke or @Regression"
        , monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

}
