package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.LoginModal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginModalSteps {

    private final LoginModal logInModal;

    public LoginModalSteps(LoginModal logInModal) {
        this.logInModal = logInModal;
    }

    @And("I enter valid credentials")
    public void iEnterValidCredentials() {
        logInModal.enterACorrectUsername();
        logInModal.enterACorrectPassword();
    }

    @And("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        logInModal.enterAnIncorrectUsername();
        logInModal.enterAnIncorrectPassword();
    }

    @And("I click on the log in modal confirmation button")
    public void iClickOnTheLogInModalConfirmationButton(){
        logInModal.clickOnTheLogInButton();
    }

    @Then("I see a wrong username or password message")
    public void iSeeAWrongUsernameOrPasswordMessage() {
        String actualAlertMessage = logInModal.getAlert();
        String expectedAlertMessage = logInModal.getIncorrectUsernameOrPasswordAlertData();
        assertEquals(actualAlertMessage, expectedAlertMessage,
                "Login modal - incorrect username or password - alert doesn't have a right message");
    }

    @Then("I see a missing username and password message")
    public void iSeeAMissingUsernameAndPasswordMessage() {
        String actualAlertMessage = logInModal.getAlert();
        String expectedAlertMessage = logInModal.getEmptyPasswordAndUsernameAlertData();
        assertEquals(actualAlertMessage, expectedAlertMessage,
                "Login modal - wrong alert message for an empty username and password");
    }

    @Then("I see a login modal appears")
    public void iSeeALoginModalAppears() {
        assertTrue(logInModal.isModalDisplayed(), "Login modal missing");
        iSeeALoginModalHeaderAppears();
    }

    @Then("I see a login modal header appears")
    public void iSeeALoginModalHeaderAppears() {
        String actualHeader = logInModal.getActualHeader();
        String expectedHeader = logInModal.getExpectedHeaderData();
        assertEquals(actualHeader, expectedHeader, "Login modal has an incorrect header");
    }
}
