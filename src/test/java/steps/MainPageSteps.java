package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MainPage;
import utils.DriverUtils;

import static org.testng.Assert.*;

public class MainPageSteps extends BaseSteps {

     private MainPage mainPage;

    public MainPageSteps(DriverUtils driverUtils) {
        super("testdata/mainPage.yaml");
        this.mainPage = new MainPage(driverUtils);
     }

    @Given("I open the main page")
    public void iOpenTheMainPage(){
        mainPage.open(data.get("homePageURL"));
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
        String expectedResult = data.get("logInWelcomeMessage");
        Assert.assertEquals(actualResult, expectedResult, "Welcome log in message incorrect");
    }

    @Then("I see a correct main page title")
    public void iSeeACorrectMainPageTitle() {
        String expectedTitle = data.get("mainPageTitle");
        String actualTitle = mainPage.getTitle(expectedTitle);
        assertEquals(actualTitle, expectedTitle, "Main page title is not correct");
    }
}
