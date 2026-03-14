@navBar @contactModal

Feature: Verify the contact modal works correctly

  Background: Contact modal is open
    Given I open the main page
    And I click on the nav bar contact button

  Scenario: Verify a message can be sent - valid credentials
    And I enter a valid contact email
    And I enter a valid contact name
    And I enter a valid contact message
    When I click on the contact modal confirmation button
    Then I see a successfully sent contact message

  @known_bug @bug
#      Expected: Message cannot be sent. Incorrect email alert message appears
#      Actual: Message can sent. Successful alert appears
  Scenario: Verify a message cannot be sent with an incorrect email - no domain
    And I enter an invalid contact email without domain
    And I enter a valid contact name
    And I enter a valid contact message
    When I click on the contact modal confirmation button
    Then I see an invalid email contact message

#  @known_bug @bug
#      Expected: Message cannot be sent. Incorrect name alert message appears
#      Actual: Message can be sent. Successful alert appears
  Scenario Outline: Verify a message cannot be sent with an incorrect name - using specials characters
    And I enter a valid contact email
    And I enter an invalid contact name with <data>
    And I enter a valid contact message
    When I click on the contact modal confirmation button
    Then I see an invalid name contact message
    Examples:
      | data               |
      | numbers            |
      | special characters |
