package com.bookcart.testclasses;

import com.bookcart.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstRun extends Driver {

    public WebDriver driver = new ChromeDriver();

    public FirstRun() {
        System.out.println("Inside Default Constructor");
    }

    @Test
    public void testOne (){
        System.out.println("Inside Test One Method");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        logger.info("Explicit wait set to 45 secs");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
        logger.info("Page Load Timeout set to 45 secs");
        driver.get("https://bookcart.azurewebsites.net/");

        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource().contains("ankitsharma_007"));
        Assert.assertTrue(driver.getPageSource().contains("ankitsharma_007"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

}
