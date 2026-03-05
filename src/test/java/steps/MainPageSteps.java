package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MainPage;
import utils.DriverUtils;

import static org.testng.Assert.*;

public class MainPageSteps extends BaseSteps {

    private final MainPage mainPage;

    public MainPageSteps(DriverUtils driverUtils) {
        super("testdata/mainPage.yaml");
        this.mainPage = new MainPage(driverUtils);
     }

    @Given("I open the main page")
    public void iOpenTheMainPage(){
        mainPage.open(data.get("homePageURL"));
    }

    @And("I click on the home button")
    public void iClickOnTheHomeButton() {
        mainPage.clickOnTheHomeButton();
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

    @And("I click on the cart button")
    public void iClickOnTheCartButton() {
        mainPage.clickOnTheCartButton();
    }

    @Then("I see a welcome message")
    public void iSeeAWelcomeMessage() {
        String actualResult = mainPage.getWelcomeMessage();
        String expectedResult = data.get("logInWelcomeMessage");
        Assert.assertEquals(actualResult, expectedResult, "Welcome log in message incorrect");
    }

    @Then("I see a correct title for the main page")
    public void iSeeACorrectTitleForTheMainPage() {
        assertPageTitle(mainPage, mainPage.getPageName(), data.get("mainPageTitle"));
    }

    @Then("I see a categories container")
    public void iSeeACategoriesContainer() {
        assertTrue(mainPage.isCategoriesContainerDisplayed());
    }
}
