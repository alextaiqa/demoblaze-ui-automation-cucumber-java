package steps;

import io.cucumber.java.en.Then;
import pages.ContactModal;

import static org.testng.Assert.*;

public class ContactModalSteps extends BaseSteps {

    private final ContactModal contactModal;


    public ContactModalSteps(ContactModal contactModal) {
        super("testdata/contactModal.yaml");
        this.contactModal = contactModal;
    }

    @Then("I see the contact modal appears")
    public void iSeeTheContactModalAppears() {
        assertTrue(contactModal.isDisplayed(), "The 'Contact' modal is not displayed");
        iSeeTheContactModalHeaderAppears();
    }

    @Then("I see the contact modal header appears")
    public void iSeeTheContactModalHeaderAppears() {
        String actualResult = contactModal.getHeaderText();
        String expectedResult = data.get("contactModalHeader");
        assertEquals(actualResult, expectedResult, "The 'Contact' modal has an incorrect header");
    }
}
