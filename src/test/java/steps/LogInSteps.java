package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInModal;

import static org.testng.Assert.assertTrue;

public class LogInSteps {

    private LogInModal logInModal;

    public LogInSteps(LogInModal logInModal){
        this.logInModal = logInModal;
    }

    @When("I click on the log in button")
    public void iClickOnTheLogInButton(){
        logInModal.clickOnTheLogInButton();
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

    @And("I click on the log in modal confirmation button")
    public void iClickOnTheLogInModalConfirmationButton(){
        logInModal.LogInModalClickOnTheLogInButton();
    }

    @And("I enter an invalid username")
    public void iEnterAnInvalidUsername() {
        logInModal.logInModalEnterAnIncorrectUsername();
    }

    @And("I enter an invalid password")
    public void iEnterAnInvalidPassword() {
        logInModal.logInModalEnterAnIncorrectPassword();
    }

    @Then("I see a wrong username message")
    public void iSeeAWrongUsernameMessage() {
        assertTrue(logInModal.isWrongUsernameAlertShown(),
                "Login modal - wrong alert message for an incorrect username");
    }

    //bug
    @Then("I see a wrong password message")
    public void iSeeAWrongPasswordMessage(){
        assertTrue(logInModal.isWrongPasswordAlertShown(),
                "Login modal - wrong alert message for an incorrect password");
    }

    @Then("I see a missing username and password message")
    public void iSeeAmissingUsernameAndPasswordMessage(){
        assertTrue(logInModal.isEmptyUsernameAndPasswordAlertShown(),
                "Login modal - wrong alert message for an empty username and password");
    }
}
