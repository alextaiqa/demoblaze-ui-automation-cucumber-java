package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LogInPage;
import utils.TestData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LogInSteps {

    private LogInPage logInPage;

    public LogInSteps(LogInPage logInPage){
        this.logInPage = logInPage;
    }

    @When("I click on the log in button")
    public void iClickOnTheLogInButton(){
        logInPage.clickOnTheLogInButton();
    }

    @And("I enter a username")
    public void iEnterAUsername(){
        logInPage.logInModalEnterACorrectUsername();
    }

    @And("I enter a password")
    public void iEnterAPassword() {
        logInPage.logInModalEnterACorrectPassword();
    }

    @And("I click on the log in modal confirmation button")
    public void iClickOnTheLogInModalConfirmationButton(){
        logInPage.LogInModalClickOnTheLogInButton();
    }

    @And("I enter a wrong username")
    public void iEnterAWrongUsername() {
        logInPage.logInModalEnterAnIncorrectUsername();
    }

    @And("I enter a wrong password")
    public void iEnterAWrongPassword() {
        logInPage.logInModalEnterAnIncorrectPassword();
    }

    @Then("I see a wrong username message")
    public void iSeeAWrongUsernameMessage() {
        assertTrue(logInPage.isWrongUsernameAlertShown(),
                "Login modal - wrong alert message for an incorrect username");
    }

    //bug
    @Then("I see a wrong password message")
    public void iSeeAWrongPasswordMessage(){
        assertTrue(logInPage.isWrongPasswordAlertShown(),
                "Login modal - wrong alert message for an incorrect password");
    }

    @Then("I see a fill out username and password message")
    public void iSeeAFillOutUsernameAndPasswordMessage(){
        assertTrue(logInPage.isEmptyUsernameAndPasswordAlertShown(),
                "Login modal - wrong alert message for an empty username and password");
    }
}
