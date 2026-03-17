@navBar @contactModal

Feature: Verify the contact modal works correctly

  Background: Contact modal is open
    Given I open the main page
    And I click on the nav bar contact button

  Scenario: Verify a message can be sent - valid credentials

    And I enter valid contact credentials

    When I click on the contact modal confirmation button
    Then I see a successfully sent contact message

  @known_bug @bug
#      Expected: Message cannot be sent. Incorrect email alert message appears
#      Actual: Message can be sent. Successful alert appears
  Scenario Outline: Verify a message cannot be sent with an incorrect email - no domain & incorrect domain
    And I enter an invalid contact email <data>
    And I enter a valid contact name
    And I enter a valid contact message
    When I click on the contact modal confirmation button
    Then I see an invalid email contact message
    Examples:
      | data                  |
      | without domain        |
      | with incorrect domain |


  @known_bug @bug
#      Expected: Message cannot be sent. Incorrect name alert message appears
#      Actual: Message can be sent. Successful alert appears
  Scenario Outline: Verify a message cannot be sent with an incorrect name - using specials characters & numbers
    And I enter a valid contact email
    And I enter an invalid contact name with <data>
    And I enter a valid contact message
    When I click on the contact modal confirmation button
    Then I see an invalid name contact message
    Examples:
      | data               |
      | numbers            |
      | special characters |

  @known_bug @bug
  Scenario: Verify a message does not accept more then 200 characters
    And I enter a valid contact email
    And I enter a valid contact name
    And I enter two hundred characters into the message field of the contact modal
    When I click on the contact modal confirmation button
    Then I see a message field has too many characters contact message

  Scenario Outline: Verify the modal can be closed - x button, closing button
    When I click on the contact modal <button> button
    Then I do not see a contact modal container
    Examples:
      | button    |
      | closing   |
      | closing X |

  Scenario: Verify all fields are cleared once the modal is closed
    And I enter valid contact credentials
    And I click on the contact modal closing button
    When I click on the nav bar contact button
    Then I see all contact modal fields are empty