package steps;

import io.cucumber.java.en.Then;
import pages.ContactModal;

import static org.testng.Assert.*;

public class ContactModalSteps {

    private final ContactModal contactModal;

    public ContactModalSteps(ContactModal contactModal) {
        this.contactModal = contactModal;
    }

    @Then("I see a contact modal appears")
    public void iSeeAContactModalAppears() {
        assertTrue(contactModal.isDisplayed(), "Contact modal is not displayed");
    }

    @Then("I see a contact modal header appears")
    public void iSeeAContactModalHeaderAppears() {
        String actualResult = contactModal.getActualHeader();
        String expectedResult = contactModal.getExpectedHeader();
        assertEquals(actualResult, expectedResult, "Contact modal has an incorrect header");
    }
}
