@ui @mainPage

Feature: Main page functionality

  Background: The main page is open
    Given I open the main page

  Scenario: Verify the title of the main page is correct
    Then I see a correct title for the main page

  Scenario Outline: Verify a nav bar, footnote, and copyright ribbon are displayed
    Then I see a <component> is displayed
    Examples:
      | component        |
      | nav bar          |
      | footnote         |
      | copyright ribbon |

  Scenario Outline: Verify there are no more than 9 items on the page for each device category
    And I click on the <category> category on the main page
    Then I see no more than nine items in the <category> category on the main page
    Examples:
      | category | category |
      | Default  | Default  |
      | Phones   | Phones   |
      | Laptops  | Laptops  |
      | Monitors | Monitors |