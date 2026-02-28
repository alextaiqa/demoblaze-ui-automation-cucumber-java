package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInModal;

import static org.testng.Assert.assertTrue;

public class LogInModalSteps {

    private LogInModal logInModal;

    public LogInModalSteps(LogInModal logInModal) {
        this.logInModal = logInModal;
    }

    @And("I enter a valid username")
    public void iEnterAValidUsername(){
        logInModal.logInModalEnterACorrectUsername();
    }

    @And("I enter a valid password")
    public void iEnterAValidPassword() {
        logInModal.logInModalEnterACorrectPassword();
    }

    @And("I enter valid credentials")
    public void iEnterValidCredentials() {
        iEnterAValidUsername();
        iEnterAValidPassword();
    }

    @And("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        logInModal.logInModalEnterAnIncorrectUsername();
        logInModal.logInModalEnterAnIncorrectPassword();
    }

    @And("I click on the log in modal confirmation button")
    public void iClickOnTheLogInModalConfirmationButton(){
        logInModal.logInModalClickOnTheLogInButton();
    }

    @Then("I see a wrong username or password message")
    public void iSeeAWrongUsernameOrPasswordMessage() {
        assertTrue(logInModal.isWrongUsernameAlertShown(),
                "Login modal - wrong alert message for an incorrect username");
    }

    @Then("I see a missing username and password message")
    public void iSeeAMissingUsernameAndPasswordMessage() {
        assertTrue(logInModal.isEmptyUsernameAndPasswordAlertShown(),
                "Login modal - wrong alert message for an empty username and password");
    }
}
