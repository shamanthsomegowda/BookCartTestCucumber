package com.bookcart.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features/"}
        , glue = {"com.bookcart.steps", "com.bookcart.hooks"}
        , tags = "@Regression"          //"@Smoke and @Regression"
        , snippets = CucumberOptions.SnippetType.CAMELCASE
        , monochrome = true
        , plugin = {
               "pretty"
              ,"html:Reports/ExecutionReport.html"
        // ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"
        }
        , dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

}
