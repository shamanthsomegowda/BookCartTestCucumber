package com.bookcart.steps;

import com.bookcart.driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps extends Driver {

    @Given("User launch bookcart application")
    public void userLaunchBookcartApplication() {
        logger.info("Launching Bookcart application");
        driver.get("https://bookcart.azurewebsites.net/");
    }

    @Given("User clicks on Login button")
    public void userClicksOnLoginButton() {
        logger.info("Clicking on Login button");
        driver.findElement(By.xpath("//span[text()=' Login ']")).click();
    }

    @When("User enters the username as {string}")
    public void userEntersTheUsernameAs(String username) {
        logger.info("Entering username: " + username);
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(username);
    }

    @When("User enters the password as {string}")
    public void userEntersThePasswordAs(String password) {
        logger.info("Entering password");
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("User clicks on Login button again")
    public void userClicksOnLoginButtonAgain() {
        logger.info("Clicking on Login button again");
        explicitWaitObj.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text()='Login']")));
        driver.findElement(By.xpath("//button/span[text()='Login']")).click();
    }

    @Then("Login should be success")
    public void loginShouldBeSuccess() {
        logger.info("Checking login success");
        Assert.assertTrue(driver.getTitle().equals("BookCart"));
    }

    @Then("Login should fail and show warning message as {string}")
    public void loginShouldFailAndShowWarningMessageAs(String expectedMsg) {
        logger.info("Checking login failure");
        String errorMsg = driver.findElement(By.xpath("//mat-error[contains(text(),'incorrect')]")).getText();
        Assert.assertEquals(errorMsg, expectedMsg);
    }

    @Then("Logout")
    public void logout() {
        logger.info("Logging out");
        explicitWaitObj.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='mdc-button__label']/span)[1]")));
        driver.findElement(By.xpath("(//span[@class='mdc-button__label']/span)[1]")).click();
        driver.findElement(By.xpath("//span[text()='Logout']")).click();
    }
}