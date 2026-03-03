@mainPage

Feature: Testing main page elements

  Background: The main page is open
    Given I open the main page

  Scenario: Verify the title of the main page is correct
    Then I see a correct main page title

  Scenario Outline: Verify that all nav bar modals are displayed on click ("Contact", "About us", "Log in", "Sign up")
    When I click on the <button> button
    Then I see the <modal> modal appears
    Examples:
      | button   | modal    |
      | contact  | contact  |
      | about us | about us |
      | log in   | login    |
      | sign up  | sign up  |

