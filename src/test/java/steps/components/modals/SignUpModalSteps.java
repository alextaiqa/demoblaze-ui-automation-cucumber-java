package steps.components.modals;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.components.modals.SignUpModal;
import steps.BaseSteps;
import utils.TestData;
import utils.TestDataGenerator;

import static org.testng.Assert.*;

public class SignUpModalSteps extends BaseSteps {
    private final SignUpModal signUpModal;
    private final TestData loginData;
    private final TestDataGenerator dataGenerator;

    // =======================
// CONSTRUCTOR
// =======================
    public SignUpModalSteps(SignUpModal signUpModal, TestDataGenerator dataGenerator) {
        super("testdata/signUpModal.yaml");
        this.signUpModal = signUpModal;
        this.loginData = new TestData("testdata/loginModal.yaml");
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
        signUpModal.enterAValidPassword(dataGenerator.generatePassword());
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
        assertTrue(isSuccessfulMessageSeen, "Sign up - modal - " +
                "'Successfully signed up' message not seen on valid sign up");
    }


    @And("I enter an existing username for {string}")
    public void iEnterAnExistingUsernameFor(String user) {
        signUpModal.enterAnExistingUsernameFor(loginData.get(user + ".username"));
    }

    @And("I enter an existing password for {string}")
    public void iEnterAnExistingPasswordFor(String user) {
        signUpModal.enterAnExistingPasswordFor(loginData.get(user + ".password"));
    }

    @Then("I see a user already exists sign up message")
    public void iSeeAUserAlreadyExistsSignUpMessage() {
        boolean isExistingUserMessageSeen = signUpModal.seeAUserAlreadyExistsSignUpMessage();
        assertTrue(isExistingUserMessageSeen, "Sign up - modal - " +
                "'This user already exist.' message not seen when signing up with an existing account");
    }

    @Then("I see sign up empty fields message")
    public void iSeeSignUpEmptyFieldsMessage() {
        String actualMessage = signUpModal.getAlertText();
        String expectedMessage = data.get("emptyFieldsMessage");
        assertEquals(actualMessage, expectedMessage, "Sign up - modal - " +
                "'Please fill out Username and Password.' message not seen when signing up with empty fields");
    }

    @And("I click on the sign up modal close button")
    public void iClickOnTheSignUpModalCloseButton() {
        signUpModal.clickOnTheSignUpModalCloseButton();
    }


    //THE PROBLEM HERE IS THAT MULTIPLE MODALS HAVE THE SAME CODE - FIX THIS - BASE CLASS? GET MODAL NAME VIA ABSTRACT?
    //but all of them have different data for logging and assertions...
    @Then("I see all sign up fields are empty")
    public void iSeeAllSignUpFieldsAreEmpty() {
        assertTrue(signUpModal.isUsernameFieldEmpty(), "'Sign up' modal - name field is not empty");
        assertTrue(signUpModal.isPasswordFieldEmpty(), "'Sign up' modal - message field is not empty");
    }
}
