@mainPage

Feature: Main page functionality

  Background: The main page is open
    Given I open the main page

  Scenario: Verify the title of the main page is correct
    Then I see a correct title for the main page

  Scenario Outline: Verify that all nav bar modals are displayed on click.
    When I click on the <button> button
    Then I see the <modal> modal with a correct header appears
    Examples:
      | button   | modal    |
      | contact  | contact  |
      | about us | about us |
      | log in   | login    |
      | sign up  | sign up  |

  Scenario: Verify the "Cart" nav bar button redirects to the "Cart" page on click
    And I click on the cart button
    Then I see a place order button