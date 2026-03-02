package steps;

import io.cucumber.java.en.Then;
import pages.ContactModal;

public class ContactModalSteps {

    private final ContactModal contactModal;

    public ContactModalSteps(ContactModal contactModal) {
        this.contactModal = contactModal;
    }

    @Then("iSeeAContactModalAppears")
    public void iSeeAContactModalAppears() {

    }
}
