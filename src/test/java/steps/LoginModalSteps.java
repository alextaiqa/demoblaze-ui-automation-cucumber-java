package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.LoginModal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginModalSteps extends BaseSteps {

    private final LoginModal logInModal;

    public LoginModalSteps(LoginModal logInModal) {
        super("testdata/loginModal.yaml");
        this.logInModal = logInModal;
    }

    @And("I enter valid credentials")
    public void iEnterValidCredentials() {
        logInModal.enterACorrectUsername(data.get("correctUsername"));
        logInModal.enterACorrectPassword(data.get("correctPassword"));
    }

    @And("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        logInModal.enterAnIncorrectUsername(data.get("incorrectUsername"));
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

    @Then("I see a login modal appears")
    public void iSeeALoginModalAppears() {
        assertTrue(logInModal.isDisplayed(), "Login modal is not displayed");
        iSeeALoginModalHeaderAppears();
    }

    @Then("I see a login modal header appears")
    public void iSeeALoginModalHeaderAppears() {
        String actualHeader = logInModal.getHeaderText();
        String expectedHeader = data.get("loginModalHeader");
        assertEquals(actualHeader, expectedHeader, "Login modal has an incorrect header");
    }
}
