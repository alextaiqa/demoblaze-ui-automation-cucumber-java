@ui @mainPage

Feature: Main page functionality

  Background: The main page is open
    Given I open the main page

  Scenario: Verify the title of the main page is correct
    Then I see a correct title for the main page

  Scenario: Verify a nav bar is displayed
    Then I see a nav bar is displayed