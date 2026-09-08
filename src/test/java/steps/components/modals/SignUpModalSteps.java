package steps.components.modals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.components.modals.SignUpModal;
import steps.BaseSteps;

import static org.testng.Assert.*;

public class SignUpModalSteps extends BaseSteps {

    private final SignUpModal signUpModal;

    // =======================
// CONSTRUCTOR
// =======================
    public SignUpModalSteps(SignUpModal signUpModal) {
        super("testdata/signUpModal.yaml");
        this.signUpModal = signUpModal;
    }

    // =======================
// METHODS
// =======================
    @Then("I see the sign up modal with a correct header appears")
    public void iSeeTheSignUpModalWithACorrectHeaderAppears() {
        assertTrue(signUpModal.isDisplayed(), "The 'Sign up' modal is not displayed");
        String actualHeader = signUpModal.getHeaderText();
        String expectedHeader = data.get("signUpHeader");
        assertEquals(actualHeader, expectedHeader, "The 'Sign up' modal has an incorrect header");
    }

    @And("I enter a valid sign up username")
    public void iEnterAValidSignUpUsername() {
        signUpModal.enterAValidUsername(); // have to create randomized data - maven faker (?) library? or current time + date? Then put it into a yaml.
    }

    @And("I enter a valid sign up password")
    public void iEnterAValidSignUpPassword() {
//        signUpModal.enterAValidPassword();
    }

    @And("I enter valid sign up credentials")
    public void iEnterValidSignUpCredentials() {
//        signUpModal.enterAValidUsername();
//        signUpModal.enterAValidPassword();
    }

    @And("I click on the sign up modal confirmation button")
    public void iClickOnTheSignUpModalConfirmationButton() {
        signUpModal.clickOnTheConfirmationButton();
    }

    @Then("I see successfully signed up message")
    public void iSeeSuccessfullySignedUpMessage() {
//        signUpModal.seeSuccessfullySignedUpMessage();
    }
}
