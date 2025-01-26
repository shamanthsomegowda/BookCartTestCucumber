package com.bookcart.hooks;

import com.bookcart.driver.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class BookcartHooks extends Driver {

    @BeforeAll
    public static void setup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        logger.info("Explicit wait set to 15 secs");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        logger.info("Page Load Timeout set to 15 secs");
    }

    @Before
    public void beforeScenario(Scenario scenario){
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "image/png", scenario.getName());
        logger.info("Executing Scenario: "+ scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        logger.info("Completed execution of Scenario: "+ scenario.getName());
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
