package com.bookcart.steps;

import com.bookcart.driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps extends Driver {

    @Given("User launch bookcart application")
    public void userLaunchBookcartApplication() {
        logger.info("Inside userLaunchBookcartApplication");
        driver.get("https://bookcart.azurewebsites.net/");
    }

    @Given("User clicks on Login button")
    public void userClicksOnLoginButton() {
        logger.info("Inside userClicksOnLoginButton");
        driver.findElement(By.xpath("//span[text()=' Login ']")).click();
    }

    @When("User enters the username as {string}")
    public void userEntersTheUsernameAsGooner(String string) {
        logger.info("Inside userEntersTheUsernameAsGooner");
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(string);
    }

    @When("User enters the password as {string}")
    public void userEntersThePasswordAsGooner(String string) {
        logger.info("Inside userEntersThePasswordAsGooner");
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(string);
    }

    @When("User clicks on Login button again")
    public void userClicksOnLoginButtonAgain() {
        logger.info("Inside userClicksOnLoginButtonAgain");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//button/span[text()='Login']")).click();
    }

    @Then("Login should be success")
    public void loginShouldBeSuccess() {
        logger.info("Inside loginShouldBeSuccess");
        Assert.assertTrue(driver.getTitle().equals("BookCart"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Login should fail and show warning message as {string}")
    public void loginShouldFailAndShowWarningMessageAs(String expectedMsg) {
        System.out.println("Login failed");
        String errorMsg = driver.findElement(By.xpath("//mat-error[contains(text(),'incorrect')]")).getText();
        Assert.assertEquals(errorMsg, expectedMsg);
    }

    @Then("Logout")
    public void logout() {
        String logoutPop = "(//span[@class='mdc-button__label']/span)[1]";
        driver.findElement(By.xpath(logoutPop)).click();
        driver.findElement(By.xpath("//span[text()='Logout']")).click();
    }

}
