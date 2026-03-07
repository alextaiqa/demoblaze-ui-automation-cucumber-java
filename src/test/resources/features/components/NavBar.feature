@navBar

Feature: Navigational bar functionality

  Background: The main page is open
    Given I open the main page

  Scenario Outline: Verify that all nav bar modals are displayed on click.
    When I click on the nav bar <link> link
    Then I see the <modal> modal with a correct header appears
    Examples:
      | link     | modal    |
      | contact  | contact  |
      | about us | about us |
      | log in   | login    |
      | sign up  | sign up  |

  Scenario Outline: Verifying that all nav bar links redirect correctly
    When I click on the nav bar <link> link
    Then I see a <result>
    Examples:
      | link | result               |
      | cart | place order button   |
      | home | categories container |
      | logo | categories container |