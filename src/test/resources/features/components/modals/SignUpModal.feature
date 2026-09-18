@navBar @signUpModal

Feature: "Sign up" modal functionality

  Background: The main page is open
    When I open the main page
    And I click on the nav bar "sign up" button

  Scenario: Verify a user is able to successfully sign up with valid credentials
    And I enter valid sign up credentials
    And I click on the sign up modal confirmation button
#    there are steps like these for other modals - create a base abstract class with required getters for locators
#    and then use those locators in a single function in said base instead of repeats??
    Then I see successfully signed up message

  Scenario: Verify an existing user cannot sign up with the same credentials
    And I enter an existing username for "user1"
    And I enter an existing password for "user1"
    And I click on the sign up modal confirmation button
    Then I see a user already exists sign up message

  Scenario: Verify a user cannot sign up with empty fields
    And I click on the sign up modal confirmation button
    Then I see sign up empty fields message

  Scenario: Verify a user cannot sign up with an empty username
    And I enter a valid sign up password
    And I click on the sign up modal confirmation button
    Then I see sign up empty fields message

  Scenario: Verify a user cannot sign up with an empty password
    And I enter a valid sign up username
    And I click on the sign up modal confirmation button
    Then I see sign up empty fields message

  @bug
#      Expected result: All fields contain previously entered data on reopening the modal
#      Actual result: All fields do Not contain previously entered data on reopening the modal
  Scenario: Verify all fields are cleared after the modal is closed
    And I enter a valid sign up username
    And I enter a valid sign up password
    And I click on the sign up modal close button
    And I click on the nav bar "sign up" button
    Then I see all sign up fields are empty
    Then I see all contact modal fields are empty