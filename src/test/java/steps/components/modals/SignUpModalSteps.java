package steps.components.modals;

import io.cucumber.java.en.Then;
import pages.components.modals.SignUpModal;
import steps.BaseSteps;

import static org.testng.Assert.*;

public class SignUpModalSteps extends BaseSteps {

    private final SignUpModal signUpModal;

    public SignUpModalSteps(SignUpModal signUpModal) {
        super("testdata/signUpModal.yaml");
        this.signUpModal = signUpModal;
    }

    @Then("I see the sign up modal with a correct header appears")
    public void iSeeTheSignUpModalWithACorrectHeaderAppears() {
        assertTrue(signUpModal.isDisplayed(), "The 'Sign up' modal is not displayed");
        String actualHeader = signUpModal.getHeaderText();
        String expectedHeader = data.get("signUpHeader");
        assertEquals(actualHeader, expectedHeader, "The 'Sign up' modal has an incorrect header");
    }
}
