package steps;

import io.cucumber.java.en.Then;
import pages.SignUpModal;

import static org.testng.Assert.*;

public class SignUpModalSteps extends BaseSteps {

    private final SignUpModal signUpModal;

    public SignUpModalSteps(SignUpModal signUpModal) {
        super("testdata/signUpModal.yaml");
        this.signUpModal = signUpModal;
    }

    @Then("I see the sign up modal appears")
    public void iSeeTheSignUpModalAppears() {
        assertTrue(signUpModal.isDisplayed(), "The 'Sign up' modal is not displayed");
        iSeeTheSignUpModalHeaderAppears();
    }

    @Then("I see the sign up modal header appears")
    public void iSeeTheSignUpModalHeaderAppears() {
        String actualHeader = signUpModal.getHeaderText();
        String expectedHeader = data.get("signUpHeader");
        assertEquals(actualHeader, expectedHeader, "The 'Sign up' modal has an incorrect header");
    }
}
