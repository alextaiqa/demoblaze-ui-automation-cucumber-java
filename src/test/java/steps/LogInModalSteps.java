package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.LogInModal;
import utils.TestData;

import static org.testng.Assert.assertEquals;

public class LogInModalSteps {

    private final LogInModal logInModal;

    public LogInModalSteps(LogInModal logInModal) {
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
        String actualAlertMessage = logInModal.getLogInModalAlert();
        String expectedAlertMessage = TestData.incorrectUsernameOrPasswordAlert;
        assertEquals(actualAlertMessage, expectedAlertMessage,
                "Login modal - incorrect username or password - alert doesn't have a right message");
    }

    @Then("I see a missing username and password message")
    public void iSeeAMissingUsernameAndPasswordMessage() {
        String actualAlertMessage = logInModal.getLogInModalAlert();
        String expectedAlertMessage = TestData.emptyPasswordAndUsernameAlert;
        assertEquals(actualAlertMessage, expectedAlertMessage,
                "Login modal - wrong alert message for an empty username and password");
    }
}
