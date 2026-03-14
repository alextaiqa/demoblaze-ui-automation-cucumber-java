package steps.components.modals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.components.modals.ContactModal;
import steps.BaseSteps;

import static org.testng.Assert.*;

public class ContactModalSteps extends BaseSteps {

    //access to POM
    private final ContactModal contactModal;

    //constructor
    public ContactModalSteps(ContactModal contactModal) {
        super("testdata/contactModal.yaml");
        this.contactModal = contactModal;
    }

    //methods

    // This method repeats in other nav bar modalSteps.
    // I could abstract it in a BaseModalSteps class, but I'm keeping as is for now. Seems to be better for readability.
    @Then("I see the contact modal with a correct header appears")
    public void iSeeTheContactModalWithACorrectHeaderAppears() {
        assertTrue(contactModal.isDisplayed(), "The 'Contact' modal is not displayed");
        String actualHeader = contactModal.getHeaderText();
        String expectedHeader = data.get("contactModalHeader");
        assertEquals(actualHeader, expectedHeader, "The 'Contact' modal has an incorrect header");
    }

    @And("I enter a valid contact email")
    public void iEnterAValidContactEmail() {
        contactModal.enterAValidEmail(data.get("validContactEmail"));
    }

    @And("I enter a valid contact name")
    public void iEnterAValidContactName() {
        contactModal.enterAValidName(data.get("validContactName"));
    }

    @And("I enter a valid contact message")
    public void iEnterAValidContactMessage() {
        contactModal.enterAValidMessage(data.get("validContactMessage"));
    }

    @When("I click on the contact modal confirmation button")
    public void iClickOnTheContactModalConfirmationButton() {
        contactModal.clickOnTheConfirmationButton();
    }

    @Then("I see a successfully sent contact message")
    public void iSeeASuccessfullySentContactMessage() {
        String actualResult = contactModal.getAlertText();
        String expectedResult = data.get("successfulMessage");
        assertEquals(actualResult, expectedResult,
                "Contact modal - valid credentials - successful alert message is not correct");

    }

    @And("I enter an invalid contact email without domain")
    public void iEnterAnInvalidContactEmailWithoutDomain() {
        contactModal.enterAnInvalidEmailWithoutDomain(data.get("invalidContactEmailNoDomain"));
    }

    @Then("I see an invalid email contact message")
    public void iSeeAnInvalidEmailContactMessage() {
        String actualResult = contactModal.getAlertText();
        String expectedResult = data.get("invalidEmailAlert");
        assertEquals(actualResult, expectedResult,
                "Contact modal - invalid email - no domain - incorrect alert message");
    }

    @And("I enter an invalid contact name with special characters")
    public void iEnterAnInvalidContactNameWithSpecialCharacters() {
        contactModal.enterAnInvalidNameWithSpecialCharacters(data.get("invalidContactNameWithSpecialCharacters"));
    }

    @Then("I see an invalid name contact message")
    public void iSeeAnInvalidNameContactMessage() {
        String actualResult = contactModal.getAlertText();
        String expectedResult = data.get("invalidNameAlert");
        assertEquals(actualResult, expectedResult,
                "Contact modal - invalid name - special characters - incorrect alert message");
    }
}
