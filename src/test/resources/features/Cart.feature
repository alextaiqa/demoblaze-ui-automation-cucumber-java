@cart

Feature: Cart page functionality

  @known_bug @Bug
#    Expected title: "Cart"
#    Actual title: "STORE:
  Scenario: Verify the title of the Cart page is correct
    Given I open the cart page
    Then I see a correct title for the cart page