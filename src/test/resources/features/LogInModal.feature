@logInModal

Feature: Testing Cucumber Pico Container

#  steps that happen before everything else for all the tests for this feature - a setup of sorts
  Background: Log in modal is open
    Given I open the main page
    When I click on the log in button

  Scenario: Validate a successful log in - valid credentials
    And I enter valid credentials
    And I click on the log in modal confirmation button
    Then I see a welcome message

  @known_bug
  Scenario: Validate an unsuccessful log in - invalid credentials
    And I enter invalid credentials
    And I click on the log in modal confirmation button
    Then I see a wrong username or password message

  Scenario: Validate an unsuccessful log in - empty username and password fields
    And I click on the log in modal confirmation button
    Then I see a missing username and password message

#    REVIEW THE ABOVE - REMOVE IF OUT OF SCOPE