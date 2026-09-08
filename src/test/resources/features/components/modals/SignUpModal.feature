@navBar @signUpModal

Feature: "Sign up" modal functionality

  Background: The main page is open
    When I open the main page

  @bug
  Scenario: Verify a user is able to successfully sign up with valid credentials
    And I click on the nav bar "sign up" button
    And I enter a valid sign up username
    And I enter a valid sign up password
    And I enter valid sign up credentials
    And I click on the sign up modal confirmation button
#    there are steps like these for other modals - create a base abstract class with required getters for locators
#    and then use those locators in a single function in said base instead of repeats??
    Then I see successfully signed up message