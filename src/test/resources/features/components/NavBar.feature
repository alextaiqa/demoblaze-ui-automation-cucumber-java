@navBar

Feature: Navigational bar functionality

  Background: The main page is open
    Given I open the main page

  Scenario Outline: Verify that all nav bar modals are displayed on click.
    When I click on the nav bar <button> button
    Then I see the <modal> modal with a correct header appears
    Examples:
      | button   | modal    |
      | contact  | contact  |
      | about us | about us |
      | log in   | login    |
      | sign up  | sign up  |

  Scenario Outline: Verifying that all nav bar links redirect correctly
    When I click on the nav bar <button> button
    Then I see a <result>
    Examples:
      | button | result               |
      | cart   | place order button   |
      | home   | categories container |
      | logo   | categories container |

  Scenario: Verify a user is able to log out
    And I log in
    Then I see a nav bar welcome message
    And I click on the nav bar log out button
    Then I see a sign up nav bar button