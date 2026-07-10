@ui @mainPage

Feature: Main page functionality

  Background: The main page is open
    Given I open the main page

#    ====COMPONENTS SECTION====
  Scenario: Verify the title of the main page is correct
    Then I see a correct title for the main page

  Scenario Outline: Verify a nav bar, footnote, and copyright ribbon are displayed
    Then I see a <component> is displayed
    Examples:
      | component        |
      | nav bar          |
      | footnote         |
      | copyright ribbon |

#    ====PREVIEW GALLERY SECTION====
  Scenario: Verify the item preview gallery has a correct amount of images
    Then I see the item preview gallery has a correct amount of images on the main page

  Scenario: Verify the first item is seen on page load in the item preview gallery
    Then I see the 1 image of the preview gallery on the main page

  Scenario: Verify that a user is able to navigate through each item in the preview gallery moving forward
    Then I see the 1 image of the preview gallery on the main page
    And I click on the next button of the preview gallery on the main page
    Then I see the 2 image of the preview gallery on the main page
    And I click on the next button of the preview gallery on the main page
    Then I see the 3 image of the preview gallery on the main page

  Scenario: Verify that a user is able to navigate through each item in the preview gallery moving backward
    Then I see the 1 image of the preview gallery on the main page
    And I click on the previous button of the preview gallery on the main page
    Then I see the 3 image of the preview gallery on the main page
    And I click on the previous button of the preview gallery on the main page
    Then I see the 2 image of the preview gallery on the main page

  Scenario: Verify a user is able to navigate to inactive images via preview gallery options
    Then I see the 1 image of the preview gallery on the main page
    And I click on the 2 option of the preview gallery on the main page
    Then I see the 2 image of the preview gallery on the main page
    And I click on the 1 option of the preview gallery on the main page
    Then I see the 1 image of the preview gallery on the main page
    And I click on the 3 option of the preview gallery on the main page
    Then I see the 3 image of the preview gallery on the main page

#    ====DEVICE CATEGORIES SECTION====
  Scenario Outline: Verify there are no more than 9 items on the page for each device category
    And I click on the "<category>" device category on the main page
    Then I see no more than nine items in the "<category>" category on the main page
    Examples:
      | category |
      | Default  |
      | Phones   |
      | Laptops  |
      | Monitors |

  @bug
#    Expected: color change on hover
#    Actual: same color before and after
  Scenario Outline: Verify device categories' buttons change color on hover
    And I see the "<button>" in the device categories in a default color
    And I hover over the device category "<button>" button
    Then I see the device category "<button>" button changed color
    Examples:
      | button   |
      | Phones   |
      | Laptops  |
      | Monitors |

  @bug
#      Expected: previous button is not displayed on the first page
#      Actual: previous button is displayed on the first page
  Scenario Outline: Verify that "Previous" button - in the device categories - is not displayed on the first page
    And I click on the "<category>" device category on the main page
    Then I do not see a previous button in the device category
    Examples:
      | category |
      | Phones   |
      | Laptops  |
      | Monitors |

  @bug
#    Expected: Next button is not seen on the last page
#    Actual: Next button is seen on the last page ("Phones", "Laptops", "Monitors" categories)
#    Details: The first page is the last page in this case - max number of items does not reach 9 on the first page.
#             Max number of items (9) should be displayed for the 'next' button to be seen, and next page available.
#             Second page does exist, but it shows unrelated items - a different bug.
  Scenario Outline: Verify that "Next" button - in the device categories - is not displayed on the last page
    And I click on the "<category>" device category on the main page
    And I go to the last page of the device category
    Then I do not see a next button in the "<category>" device category
    Examples:
      | category |
      | Default  |
      | Phones   |
      | Laptops  |
      | Monitors |


  Scenario Outline: Verify that device categories have no empty pages
    And I click on the "<category>" device category on the main page
    Then I see that the "<category>" device category has no empty pages
    Examples:
      | category |
      | Default  |
      | Phones   |
      | Laptops  |
      | Monitors |

  @bug
#      Expected: Duplicates not found across category pages
#      Actual: Duplicates found across category pages - 'Phones', 'Laptops', 'Monitors' categories
  Scenario Outline: Verify no duplicate items are present in any device category
    And I click on the "<category>" device category on the main page
    And I see that the "<category>" device category has no duplicate items across all of its pages
    Examples:
      | category |
      | Default  |
      | Phones   |
      | Laptops  |
      | Monitors |

  Scenario Outline: Verify that items on the first page of each category redirect to their corresponding pages
    And I click on the "<category>" device category on the main page
    Then I see that items on the first page of the "<category>" device category redirects to a corresponding page
    Examples:
      | category |
      | Default  |
      | Phones   |
      | Laptops  |
      | Monitors |

  @bug
#        Expected:
#        Actual:
  Scenario Outline: Verify that items on the first page of each category have correct titles on their pages
    And I click on the "<category>" device category on the main page
    Then I see that items on the first page of the "<category>" device category have a correct title on their pages
    Examples:
      | category |
      | Default  |
      | Phones   |
      | Laptops  |
      | Monitors |