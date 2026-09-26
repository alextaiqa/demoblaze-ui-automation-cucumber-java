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


#    change the first item step to accept {int} - so it can be used with multiple items as well!!!!!!!!!!!!!!!

    And I make a purchase of a first item in the "phones" category with valid credentials
    Then I see a purchase confirmation message

  @only
#    too long, should be simplified
#    always the first item? But item amount can change, so a test might fail. So first?I
  Scenario: Verify a user is able to successfully make a purchase of multiple items with valid data


    Given I open the main page
#    add a data table here and implement DataTable in the steps, then via shoppingFlow via single item step above
#    change data table to map of strings in the step and pass it into the flow, consider making a pojo for this
#    consider making a DataTableConverter class



    And I add the first item in the "phones" device category to the cart
    And I open the main page
    And I add the first item in the "laptops" device category to the cart
    And I open the main page
    And I add the first item in the "monitors" device category to the cart
    And I open the cart page
    And I click on the place order button
    And I enter valid place order details in the cart modal
    And I click on the place order purchase button
    Then I see a purchase confirmation message

