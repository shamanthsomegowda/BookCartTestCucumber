@Regression
Feature: Bookcart application validation

  # These steps will be executed before each scenario in the feature.
  Background:
    Given User launch bookcart application
    And User clicks on Login button

# This scenario tests the login failure case with incorrect password
  @Smoke
  Scenario: successful login

    When User enters the username as "Gooner"
    And User enters the password as "Gooner@2004"
    And User clicks on Login button again
    Then Login should be success
    And Logout

# This scenario tests the login failure case with incorrect password
    Scenario: Login failure

    When User enters the username as "Gooner"
    And User enters the password as "Goonerss@2004"
    And User clicks on Login button again
    Then Login should fail and show warning message as "Username or Password is incorrect."

