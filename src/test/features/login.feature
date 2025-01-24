Feature: Bookcart application validation

  Background:
    Given User launch bookcart application
    And User clicks on Login button

  @Regression @Smoke
  Scenario: successful login

    When User enters the username as "Gooner"
    And User enters the password as "Gooner@2004"
    And User clicks on Login button again
    Then Login should be success
    And Logout


  @Smoke
  Scenario: Login failure

    When User enters the username as "Gooner"
    And User enters the password as "Goonerss@2004"
    And User clicks on Login button again
    Then Login should fail and show warning message as "Username or Password is incorrect."

