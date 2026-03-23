@ui @cart

Feature: Cart page functionality

  Scenario Outline: Verify the nav bar is displayed
    Given I open the cart page
    Then I see a <component> is displayed
    Examples:
      | component        |
      | nav bar          |
      | footnote         |
      | copyright ribbon |

  @known_bug @bug
#    Expected title: "Cart"
#    Actual title: "STORE"
  Scenario: Verify the title of the Cart page is correct
    Given I open the cart page
    Then I see a correct title for the cart page

  @known_bug @bug
#      Expected: 'Place Order' modal does not open while the cart is empty
#      Actual: 'Place Order' modal opens while the cart is empty
  Scenario:
    Given I open the main page
    And I click on the nav bar cart button
    When I click on the place order button
    Then I do not see a place order modal