@navBar @logInModal

Feature: Verify that login modal functionality works correctly

#  steps that happen before everything else for all the tests for this feature
  Background: Log in modal is open
    Given I open the main page
    When I click on the nav bar log in button

  Scenario: Validate a successful log in - valid credentials
    And I enter valid login credentials
    And I click on the log in modal confirmation button
    Then I see a nav bar welcome message

  @known_bug @bug
#    Expected result: "Incorrect username or password."
#    Actual result: "User does not exist."
  Scenario: Validate an unsuccessful log in - invalid credentials
    And I enter invalid login credentials
    And I click on the log in modal confirmation button
    Then I see a wrong username or password login message

  Scenario: Validate an unsuccessful log in - empty username and password fields
    And I click on the log in modal confirmation button
    Then I see a missing username and password login message

  @known_bug @bug
  Scenario: Verify that all fields get cleared when the modal is closed
    And I enter valid login credentials
    And I click on the login modal closing button
    When I click on the nav bar log in button
    Then I see all login modal fields are empty