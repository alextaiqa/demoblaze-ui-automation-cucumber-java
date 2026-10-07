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
    And I make sure the cart is empty
    When I click on the place order button
    Then I do not see a place order modal

  @bug
#    Expected: only last 4 digits of a credit card are displayed
#    Actual: all digits of a credit card are displayed
  Scenario: Verify a user is able to successfully make a purchase of a single item with valid data
    Given I open the main page
    And I successfully purchase the 1 item in the "phones" category with valid credentials
    Then I see a purchase confirmation message

  @bug
#    As above - only last 4 digits of a credit card should be displayed. Not the entire thing
  Scenario: Verify a user is able to successfully make a purchase of multiple items with valid data
    Given I open the main page
    And I successfully purchase the following items with valid credentials:
      | category | item |
      | default  | 3    |
      | phones   | 1    |
      | laptops  | 2    |
      | monitors | 1    |
    Then I see a purchase confirmation message



