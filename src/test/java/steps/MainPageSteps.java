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

    @And("I click on the nav bar logo link")
    public void iClickOnTheNavBarLogoLink() {
        mainPage.clickOnTheNavBarLogoLink();
    }

    @And("I click on the nav bar home link")
    public void iClickOnTheNavBarHomeLink() {
        mainPage.clickOnTheNavBarHomeLink();
    }

    @When("I click on the nav bar contact link")
    public void iClickOnTheNavBarContactLink() {
        mainPage.clickOnTheNavBarContactLink();
    }

    @When("I click on the nav bar about us link")
    public void iClickOnTheNavBarAboutUsLink() {
        mainPage.clickOnTheNavBarAboutUsLink();
    }

    @When("I click on the nav bar log in link")
    public void iClickOnTheNavBarLogInLink() {
        mainPage.clickOnTheNavBarLogInLink();
    }

    @When("I click on the nav bar sign up link")
    public void iClickOnTheNavBarSignUpLink() {
        mainPage.clickOnTheNavBarSignUpLink();
    }

    @And("I click on the nav bar cart link")
    public void iClickOnTheNavBarCartLink() {
        mainPage.clickOnTheNavBarCartLink();
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
