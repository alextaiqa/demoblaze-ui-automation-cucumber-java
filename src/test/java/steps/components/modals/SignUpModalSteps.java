package steps.components.modals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.login.LoginModalData;
import models.SignUpModalData;
import pages.components.modals.SignUpModal;
import steps.BaseSteps;
import data.TestDataProvider;
import utils.TestDataGenerator;

import static org.testng.Assert.*;

public class SignUpModalSteps extends BaseSteps {
    private final SignUpModal signUpModal;
    private final SignUpModalData signUpModalData;
    private final LoginModalData loginModalData;
    private final TestDataGenerator dataGenerator;

    // =======================
// CONSTRUCTOR
// =======================
    public SignUpModalSteps(SignUpModal signUpModal, TestDataGenerator dataGenerator, TestDataProvider testDataProvider) {


        super("testdata/signUpModal.yaml"); //REMOVE FROM BASE, THEN HERE when finished with other steps


        this.signUpModal = signUpModal;
        this.loginModalData = testDataProvider.getLoginModalData();
        this.dataGenerator = dataGenerator;
        this.signUpModalData = testDataProvider.getSignUpModalData();
    }

    // =======================
// METHODS
// =======================
    @Then("I see the sign up modal with a correct header appears")
    public void iSeeTheSignUpModalWithACorrectHeaderAppears() {
        assertTrue(signUpModal.isDisplayed(), "The 'Sign up' modal is not displayed");

        String actualHeader = signUpModal.getHeaderText();
        String expectedHeader = signUpModalData.getSignUpHeader();
        assertEquals(actualHeader, expectedHeader, "The 'Sign up' modal has an incorrect header");
    }

    @And("I enter a valid sign up username")
    public void iEnterAValidSignUpUsername() {
        signUpModal.enterValidUsername(dataGenerator.generateUsername());
    }

    @And("I enter a valid sign up password")
    public void iEnterAValidSignUpPassword() {
        signUpModal.enterValidPassword(dataGenerator.generatePassword());
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
        String actualMessage = signUpModal.getSuccessfullySignedUpMessage();
        String expectedMessage = signUpModalData.getSuccessfulSignUpMessage();
        assertEquals(actualMessage, expectedMessage, "Sign up - modal - " +
                "'Successfully signed up' message not seen on valid sign up");
    }


    @And("I enter an existing username for {string}")
    public void iEnterAnExistingUsernameFor(String user) {
        String username = loginModalData.getUser(user).getUsername();
        signUpModal.enterExistingUsernameFor(username);
    }

    @And("I enter an existing password for {string}")
    public void iEnterAnExistingPasswordFor(String user) {
        String password = loginModalData.getUser(user).getPassword();
        signUpModal.enterExistingPasswordFor(password);
    }

    @Then("I see a user already exists sign up message")
    public void iSeeAUserAlreadyExistsSignUpMessage() {
        boolean isExistingUserMessageSeen = signUpModal.seeUserAlreadyExistsMessage();
        assertTrue(isExistingUserMessageSeen, "Sign up modal - " +
                "'This user already exist.' message not seen when signing up with an existing account");
    }

    @Then("I see sign up empty fields message")
    public void iSeeSignUpEmptyFieldsMessage() {
        String actualMessage = signUpModal.getAlertText();
        String expectedMessage = signUpModalData.getEmptyFieldsMessage();
        assertEquals(actualMessage, expectedMessage, "Sign up modal - " +
                "'Please fill out Username and Password.' message not seen when signing up with empty fields");
    }

    @And("I click on the sign up modal close button")
    public void iClickOnTheSignUpModalCloseButton() {
        signUpModal.clickCloseButton();
    }


    //rename things - shorten them
    //send more things to their Bases

    //THE PROBLEM HERE IS THAT MULTIPLE MODALS HAVE THE SAME CODE - FIX THIS - BASE CLASS? GET MODAL NAME VIA ABSTRACT?
    //but all of them have different data for logging and assertions...
    @Then("I see all sign up fields are empty")
    public void iSeeAllSignUpFieldsAreEmpty() {
        assertTrue(signUpModal.isUsernameFieldEmpty(), "Sign up modal - name field is not empty");
        assertTrue(signUpModal.isPasswordFieldEmpty(), "Sign up modal - message field is not empty");
    }
}
