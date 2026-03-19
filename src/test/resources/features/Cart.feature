@ui @cart

Feature: Cart page functionality

  @only
  Scenario:
    Given I open the cart page
    Then I see a nav bar is displayed

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