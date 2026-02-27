@login

Feature: Testing Cucumber Pico Container

#  steps that happen before everything else for all the tests for this feature - a setup of sorts
  Background: Log in modal is open
    Given I open the main page
    When I click on the log in button

  Scenario: Validate a successful log in
    And I enter valid credentials
    And I click on the log in modal confirmation button
    Then I see a welcome message

  Scenario: Validate an unsuccessful log in - wrong username
    And I enter an invalid username
    And I enter a valid password
    And I click on the log in modal confirmation button
    Then I see a wrong username message

  Scenario: Validate an unsuccessful log in - wrong password
    And I enter a valid username
    And I enter an invalid password
    And I click on the log in modal confirmation button
    Then I see a wrong password message

  Scenario: Validate an unsuccessful log in - No username, no password
    And I click on the log in modal confirmation button
    Then I see a missing username and password message

#    REVIEW THE ABOVE - REMOVE IF OUT OF SCOPE