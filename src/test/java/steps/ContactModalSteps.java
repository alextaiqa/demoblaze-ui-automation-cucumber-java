package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import pages.ContactModal;

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
}
