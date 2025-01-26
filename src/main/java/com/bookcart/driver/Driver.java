package com.bookcart.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    public static WebDriver driver = new ChromeDriver();
    public static Logger logger = LogManager.getLogger("Book Cart Test");
    public static WebDriverWait explicitWaitObj = new WebDriverWait(driver, Duration.ofSeconds(10));
}
