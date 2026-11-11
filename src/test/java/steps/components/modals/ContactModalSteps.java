package steps.components.modals;

import data.TestDataProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ContactModalData;
import pages.components.modals.ContactModal;

import static org.testng.Assert.*;

public class ContactModalSteps {

    //access to POM
    private final ContactModal contactModal;
    private final ContactModalData contactModalData;

    /*=========================
        CONSTRUCTOR
    =========================*/
    public ContactModalSteps(ContactModal contactModal, TestDataProvider testDataProvider) {
        this.contactModal = contactModal;
        this.contactModalData = testDataProvider.getContactModalData();
    }

    /*=========================
        METHODS
    =========================*/

    // This method repeats in other nav bar modalSteps.
    // I could abstract it in a BaseModalSteps class, but I'm keeping as is for now. Seems to be better for readability.
    @Then("I see the contact modal with a correct header appears")
    public void iSeeTheContactModalWithACorrectHeaderAppears() {
        assertTrue(contactModal.isDisplayed(), "The 'Contact' modal is not displayed");

        String actualHeader = contactModal.getHeader();
        String expectedHeader = contactModalData.getHeader();
        assertEquals(actualHeader, expectedHeader, "The 'Contact' modal has an incorrect header");
    }

    @And("I enter a valid contact email")
    public void iEnterAValidContactEmail() {
        String validEmail = contactModalData.getValidEmail();
        contactModal.enterValidEmail(validEmail);
    }

    @And("I enter a valid contact name")
    public void iEnterAValidContactName() {
        String validName = contactModalData.getValidName();
        contactModal.enterValidName(validName);
    }

    @And("I enter a valid contact message")
    public void iEnterAValidContactMessage() {
        String validMessage = contactModalData.getValidMessage();
        contactModal.enterValidMessage(validMessage);
    }

    @And("I enter valid contact credentials")
    public void iEnterValidContactCredentials() {
        iEnterAValidContactEmail();
        iEnterAValidContactName();
        iEnterAValidContactMessage();
    }

    @When("I click on the contact modal confirmation button")
    public void iClickOnTheContactModalConfirmationButton() {
        contactModal.clickConfirmationButton();
    }

    @Then("I see a successfully sent contact message")
    public void iSeeASuccessfullySentContactMessage() {
        String actualResult = contactModal.getSuccessfulAlert();
        String expectedResult = contactModalData.getSuccessfulMessage();
        assertEquals(actualResult, expectedResult,
                "Contact modal - valid credentials - successful alert message is not correct");

    }

    @And("I enter an invalid contact email without domain")
    public void iEnterAnInvalidContactEmailWithoutDomain() {
        String invalidEmail = contactModalData.getInvalidEmailNoDomain();
        contactModal.enterInvalidEmailWithoutDomain(invalidEmail);
    }

    @Then("I see an invalid email contact message")
    public void iSeeAnInvalidEmailContactMessage() {
        String actualResult = contactModal.getInvalidEmailAlert();
        String expectedResult = contactModalData.getInvalidEmailAlert();
        assertEquals(actualResult, expectedResult,
                "Contact modal - invalid email - no domain - incorrect alert message");
    }

    @And("I enter an invalid contact name with special characters")
    public void iEnterAnInvalidContactNameWithSpecialCharacters() {
        String invalidEmail = contactModalData.getInvalidNameWithSpecialCharacters();
        contactModal.enterInvalidNameWithSpecialCharacters(invalidEmail);
    }

    @Then("I see an invalid name contact message")
    public void iSeeAnInvalidNameContactMessage() {
        String actualResult = contactModal.getInvalidNameAlert();
        String expectedResult = contactModalData.getInvalidNameAlert();
        assertEquals(actualResult, expectedResult,
                "Contact modal - invalid name - special characters - incorrect alert message");
    }

    @And("I enter an invalid contact name with numbers")
    public void iEnterAnInvalidContactNameWithNumbers() {
        String invalidName = contactModalData.getInvalidNameWithNumbers();
        contactModal.enterInvalidNameWithNumbers(invalidName);
    }

    @And("I enter an invalid contact email with incorrect domain")
    public void iEnterAnInvalidContactEmailWithIncorrectDomain() {
        String invalidEmail = contactModalData.getInvalidEmailWithIncorrectDomain();
        contactModal.enterInvalidEmailWithIncorrectDomain(invalidEmail);
    }

    @And("I enter two hundred characters into the message field of the contact modal")
    public void iEnterTwoHundredCharactersIntoTheMessageFieldOfTheContactModal() {
        contactModal.enterTwoHundredCharsIntoMessageField();
    }

    @Then("I see a message field has too many characters contact message")
    public void iSeeAMessageFieldHasTooManyCharactersContactMessage() {
        String actualResult = contactModal.getTooManyCharactersAlert();
        String expectedResult = contactModalData.getMessageBoundaryAlert();
        assertEquals(actualResult, expectedResult,
                "Contact modal - message field - boundary testing - too many characters");
    }

    @When("I click on the contact modal closing button")
    public void iClickOnTheContactModalClosingButton() {
        contactModal.clickCloseButton();
    }

    @When("I click on the contact modal closing X button")
    public void iClickOnTheContactModalClosingXButton() {
        contactModal.clickXButton();
    }

    @Then("I do not see a contact modal container")
    public void iDoNotSeeAContactModalContainer() {
        assertTrue(contactModal.isNotDisplayed(), "Contact modal is still displayed");
    }

    @Then("I see all contact modal fields are empty")
    public void iSeeAllContactModalFieldsAreEmpty() {
        assertTrue(contactModal.isEmailFieldEmpty(), "Contact modal - email field is not empty");
        assertTrue(contactModal.isNameFieldEmpty(), "Contact modal - name field is not empty");
        assertTrue(contactModal.isMessageFieldEmpty(), "Contact modal - message field is not empty");
    }
}
