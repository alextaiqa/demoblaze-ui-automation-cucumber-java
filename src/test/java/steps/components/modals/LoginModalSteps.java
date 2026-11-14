package steps.components.modals;

import data.TestDataProvider;
import flows.AuthFlow;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.login.LoginModalData;
import models.login.UserCredentials;
import pages.components.modals.LoginModal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginModalSteps {

    /*=========================
        GLOBAL VARIABLES
    =========================*/
    private final LoginModal logInModal;
    private final AuthFlow authFlow;
    private final LoginModalData loginModalData;

    /*=========================
        CONSTRUCTOR
    =========================*/
    public LoginModalSteps(LoginModal logInModal,
                           AuthFlow authFlow,
                           TestDataProvider testDataProvider) {

//        super("testdata/loginModal.yaml");
        this.logInModal = logInModal;
        this.authFlow = authFlow;
        this.loginModalData = testDataProvider.getLoginModalData();
    }

    /*=========================
        METHODS
    =========================*/
    @And("I log in as {string}")
    public void iLogInAs(String userNum) {
        UserCredentials user = loginModalData.getUser(userNum);
        String username = user.getUsername();
        String password = user.getPassword();

        authFlow.login(username, password);
    }

    @And("I enter valid login credentials for {string}")
    public void iEnterValidLoginCredentials(String userNum) {
        iEnterAValidLoginUsername(userNum);
        iEnterAValidLoginPassword(userNum);
    }

    @And("I enter a valid login username for {string}")
    public void iEnterAValidLoginUsername(String userNum) {
        String username = loginModalData.getUser(userNum).getUsername();
        logInModal.enterValidUsername(username);
    }

    @And("I enter a valid login password for {string}")
    public void iEnterAValidLoginPassword(String userNum) {
        String password = loginModalData.getUser(userNum).getPassword();
        logInModal.enterACorrectPassword(password);
    }

    @And("I enter invalid login credentials")
    public void iEnterInvalidLoginCredentials() {
        iEnterAnInvalidLoginUsername();
        iEnterAnInvalidLoginPassword();
    }

    @And("I enter an invalid login username")
    public void iEnterAnInvalidLoginUsername() {
        String invalidUsername = loginModalData.getInvalidUsername();
        logInModal.enterAnIncorrectUsername(invalidUsername);
    }

    @And("I enter an invalid login password")
    public void iEnterAnInvalidLoginPassword() {
        String invalidPassword = loginModalData.getInvalidPassword();
        logInModal.enterAnIncorrectPassword(invalidPassword);
    }

    @And("I click on the log in modal confirmation button")
    public void iClickOnTheLogInModalConfirmationButton(){
        logInModal.clickOnTheLogInButton();
    }

    @Then("I see a wrong username or password login message")
    public void iSeeAWrongUsernameOrPasswordLoginMessage() {
        String actualMessage = logInModal.getInvalidFieldsAlert();
        String expectedMessage = loginModalData.getInvalidCredentialsAlert();
        assertEquals(actualMessage, expectedMessage,
                "Login modal - incorrect username or password - alert doesn't have a right message");
    }

    @Then("I see a missing username and password login message")
    public void iSeeAMissingUsernameAndPasswordLoginMessage() {
        String actualMessage = logInModal.getEmptyFieldsAlert();
        String expectedMessage = loginModalData.getEmptyCredentialsAlert();
        assertEquals(actualMessage, expectedMessage,
                "Login modal - wrong alert message for an empty username and password");
    }

    @Then("I see the login modal with a correct header appears")
    public void iSeeTheLoginModalWithACorrectHeaderAppears() {
        assertTrue(logInModal.isDisplayed(), "The 'Log in' modal is not displayed");
        String actualHeader = logInModal.getHeader();
        String expectedHeader = loginModalData.geHeader();
        assertEquals(actualHeader, expectedHeader, "The 'Log in' modal has an incorrect header");
    }

    @And("I click on the login modal closing button")
    public void iClickOnTheLoginModalClosingButton() {
        logInModal.clickOnTheClosingButton();
    }

    @Then("I see all login modal fields are empty")
    public void iSeeAllLoginModalFieldsAreEmpty() {
        assertTrue(logInModal.isUsernameFieldEmpty(),
                "'Log in' modal - username field is not cleared after the modal is closed");
        assertTrue(logInModal.isPasswordFieldEmpty(),
                "'Log in' modal - password field is not cleared after the modal is closed");
    }
}
