package steps.components.modals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.components.modals.SignUpModal;
import steps.BaseSteps;
import utils.TestDataGenerator;

import static org.testng.Assert.*;

public class SignUpModalSteps extends BaseSteps {

    private final SignUpModal signUpModal;
    private final TestDataGenerator dataGenerator;

    // =======================
// CONSTRUCTOR
// =======================
    public SignUpModalSteps(SignUpModal signUpModal, TestDataGenerator dataGenerator) {
        super("testdata/signUpModal.yaml");
        this.signUpModal = signUpModal;
        this.dataGenerator = dataGenerator;
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
        signUpModal.enterAValidUsername(dataGenerator.generateUsername());
    }

    @And("I enter a valid sign up password")
    public void iEnterAValidSignUpPassword() {
        signUpModal.enterAValidPassword(dataGenerator
                .generatePassword(null, true, true));

        //create an option for a bdd user to choose if password has numbers &/or special characters? Overload? Useful at all?
        //any actual reason to use the same username as generated in the actual username in the password? Data match? Why?
    }

    @And("I enter valid sign up credentials")
    public void iEnterValidSignUpCredentials() {
        iEnterAValidSignUpUsername();
        iEnterAValidSignUpPassword();
    }

    @And("I click on the sign up modal confirmation button")
    public void iClickOnTheSignUpModalConfirmationButton() {
        signUpModal.clickOnTheConfirmationButton();
    }

    @Then("I see successfully signed up message")
    public void iSeeSuccessfullySignedUpMessage() {
        boolean isSuccessfulMessageSeen = signUpModal.seeSuccessfullySignedUpMessage();
        assertTrue(isSuccessfulMessageSeen, "Sign up - modal - 'Successfully signed up' message not seen on valid sign up");
    }
}
