package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MainPage;
import utils.DriverUtils;

import static org.testng.Assert.*;

public class MainPageSteps {

     private MainPage mainPage;

    public MainPageSteps(DriverUtils driverUtils) {
        this.mainPage = new MainPage(driverUtils);
     }

    @Given("I open the main page")
    public void iOpenTheMainPage(){
        mainPage.open();
    }

    @When("I click on the contact button")
    public void iClickOnTheContactButton() {
        mainPage.clickOnTheContactButton();
    }

    @When("I click on the about us button")
    public void iClickOnTheAboutUsButton() {
        mainPage.clickOnTheAboutUsButton();
    }

    @When("I click on the log in button")
    public void iClickOnTheLogInButton() {
        mainPage.clickOnTheLogInButton();
    }

    @When("I click on the sign up button")
    public void iClickOnTheSignUpButton() {
        mainPage.clickOnTheSignUpButton();
    }

    @Then("I see a welcome message")
    public void iSeeAWelcomeMessage() {
        String actualResult = mainPage.getWelcomeMessage();
        String expectedResult = mainPage.getExpectedWelcomeMessage();
        Assert.assertEquals(actualResult, expectedResult, "Welcome log in message incorrect");
    }

    @Then("I see a correct main page title")
    public void iSeeACorrectMainPageTitle() {
        String actualTitle = mainPage.getTitle();
        String expectedTitle = mainPage.getExpectedTitle();
        assertEquals(actualTitle, expectedTitle, "Main page title is not correct");
    }
}
