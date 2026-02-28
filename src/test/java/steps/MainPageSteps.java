package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MainPage;
import utils.DriverUtils;
import utils.TestData;

import static org.testng.Assert.*;

public class MainPageSteps {

     private MainPage mainPage;

    public MainPageSteps(DriverUtils driverUtils) {
        this.mainPage = new MainPage(driverUtils);
     }

    @Given("I open the main page")
    public void iOpenTheMainPage(){
        mainPage.openMainPage();
    }

    @When("I click on the log in button")
    public void iClickOnTheLogInButton() {
        mainPage.clickOnTheLogInButton();
    }

    @Then("I see a welcome message")
    public void iSeeAWelcomeMessage() {
        String actualResult = mainPage.getAWelcomeMessage();
        String expectedResult = TestData.logInWelcomeMessage;
        Assert.assertEquals(actualResult, expectedResult, "Welcome log in message incorrect");
    }

    @Then("I see a correct main page title")
    public void iSeeACorrectMainPageTitle() {
        String actualTitle = mainPage.getMainPageTitle();
        String expectedTitle = TestData.mainPageTitle;
        assertEquals(actualTitle, expectedTitle, "Main page title is not correct");
    }
}
