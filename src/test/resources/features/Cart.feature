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
#    Expected title: The title is "Cart"
#    Actual title: The title is "STORE"
  Scenario: Verify the title of the Cart page is correct
    Given I open the cart page
    Then I see a correct title for the cart page

  @known_bug @bug
#      Expected: 'Place Order' modal does not open while the cart is empty
#      Actual: 'Place Order' modal opens while the cart is empty
  Scenario: Verify a 'Place Order' modal does not open when the cart is empty
    Given I open the main page
    And I click on the nav bar "cart" button
    When I click on the place order button
    Then I do not see a place order modal

  Scenario: Verify a user is able to successfully make a purchase of a single item with valid data
    Given I open the main page
    And I make a purchase of a first item in the "phones" category with valid credentials
    Then I see a purchase confirmation message

  @only
#    too long, should be simplified
#    always the first item? But item amount can change, so a test might fail. So first?
  Scenario: Verify a user is able to successfully make a purchase of multiple items with valid data
    Given I open the main page
    And I add the first item in the "default" device category to the cart
    And I click on the nav bar "home" button
    And I add the first item in the "phones" device category to the cart
    And I click on the nav bar "home" button
    And I add the first item in the "laptops" device category to the cart
    And I click on the nav bar "home" button
    And I add the first item in the "monitors" device category to the cart
    And I click on the nav bar "cart" button
    And I click on the place order button
    And I enter valid place order details in the cart modal
    And I click on the place order purchase button
    Then I see a purchase confirmation message

