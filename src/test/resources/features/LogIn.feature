@login

Feature: Testing Cucumber Pico Container

#  steps that happen before everything else for all the tests for this feature - a setup of sorts
  Background: Log in modal is open
    Given I open the main page
    When I click on the log in button

  Scenario: Validate a successful log in
    And I enter a username
    And I enter a password
    And I click on the log in modal confirmation button
    Then I see a welcome message

  Scenario: Validate an unsuccessful log in - wrong username
    And I enter a wrong username
    And I enter a password
    And I click on the log in modal confirmation button
    Then I see a wrong username message

  Scenario: Validate an unsuccessful log in - wrong password
    And I enter a username
    And I enter a wrong password
    And I click on the log in modal confirmation button
    Then I see a wrong password message

  Scenario: Validate an unsuccessful log in - No username, no password
    And I click on the log in modal confirmation button
    Then I see a fill out username and password message