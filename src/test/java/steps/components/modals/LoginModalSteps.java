package steps.components.modals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.components.modals.LoginModal;
import steps.BaseSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginModalSteps extends BaseSteps {

    private final LoginModal logInModal;

    public LoginModalSteps(LoginModal logInModal) {
        super("testdata/loginModal.yaml");
        this.logInModal = logInModal;
    }

    @And("I enter valid login credentials")
    public void iEnterValidLoginCredentials() {
        iEnterAValidLoginUsername();
        iEnterAValidLoginPassword();
    }

    @And("I enter a valid login username")
    public void iEnterAValidLoginUsername() {
        logInModal.enterACorrectUsername(data.get("correctUsername"));
    }

    @And("I enter a valid login password")
    public void iEnterAValidLoginPassword() {
        logInModal.enterACorrectPassword(data.get("correctPassword"));
    }

    @And("I enter invalid login credentials")
    public void iEnterInvalidLoginCredentials() {
        iEnterAnInvalidLoginUsername();
        iEnterAnInvalidLoginPassword();
    }

    @And("I enter an invalid login username")
    public void iEnterAnInvalidLoginUsername() {
        logInModal.enterAnIncorrectUsername(data.get("incorrectUsername"));
    }

    @And("I enter an invalid login password")
    public void iEnterAnInvalidLoginPassword() {
        logInModal.enterAnIncorrectPassword(data.get("incorrectPassword"));
    }

    @And("I click on the log in modal confirmation button")
    public void iClickOnTheLogInModalConfirmationButton(){
        logInModal.clickOnTheLogInButton();
    }

    @Then("I see a wrong username or password message")
    public void iSeeAWrongUsernameOrPasswordMessage() {
        String actualAlertMessage = logInModal.getAlert();
        String expectedAlertMessage = data.get("incorrectUsernameOrPasswordAlert");
        assertEquals(actualAlertMessage, expectedAlertMessage,
                "Login modal - incorrect username or password - alert doesn't have a right message");
    }

    @Then("I see a missing username and password message")
    public void iSeeAMissingUsernameAndPasswordMessage() {
        String actualAlertMessage = logInModal.getAlert();
        String expectedAlertMessage = data.get("emptyPasswordAndUsernameAlert");
        assertEquals(actualAlertMessage, expectedAlertMessage,
                "Login modal - wrong alert message for an empty username and password");
    }

    @Then("I see the login modal with a correct header appears")
    public void iSeeTheLoginModalWithACorrectHeaderAppears() {
        assertTrue(logInModal.isDisplayed(), "The 'Log in' modal is not displayed");
        String actualHeader = logInModal.getHeaderText();
        String expectedHeader = data.get("loginModalHeader");
        assertEquals(actualHeader, expectedHeader, "The 'Log in' modal has an incorrect header");
    }
}
