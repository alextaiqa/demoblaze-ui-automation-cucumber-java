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

  Scenario: Verify the item preview gallery has a correct amount of images
    Then I see the item preview gallery has a correct amount of images on the main page

  @only
  Scenario: Verify the first item is seen on page load in the item preview gallery
    Then I see the first image of the preview gallery on the main page

  @only
  Scenario: Verify that a user is able to navigate through each item in the preview gallery
    Then I see the first image of the preview gallery on the main page
    And I click on the next button of the preview gallery on the main page
    Then I see the second image of the preview gallery on the main page
    And I click on the next button of the preview gallery on the main page
    Then I see the third image of the preview gallery on the main page

  @only
  Scenario: Verify that a user is able to navigate through each item in the preview gallery
    Then I see the first image of the preview gallery on the main page
    And I click on the previous button of the preview gallery on the main page
    Then I see the third image of the preview gallery on the main page
    And I click on the previous button of the preview gallery on the main page
    Then I see the second image of the preview gallery on the main page


