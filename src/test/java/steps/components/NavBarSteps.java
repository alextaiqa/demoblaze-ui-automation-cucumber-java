package steps.components;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.components.NavBar;
import steps.BaseSteps;

import static org.testng.Assert.*;

public class NavBarSteps extends BaseSteps {

    private final NavBar navBar;

    //constructor
    public NavBarSteps(NavBar navBar) {
        super("testdata/navBar.yaml");
        this.navBar = navBar;
    }

    //steps
    @And("I click on the nav bar logo button")
    public void iClickOnTheNavBarLogoButton() {
        navBar.clickOnTheLogo();
    }

    @And("I click on the nav bar home button")
    public void iClickOnTheNavBarHomeButton() {
        navBar.clickOnTheHomeButton();
    }

    @When("I click on the nav bar contact button")
    public void iClickOnTheNavBarContactButton() {
        navBar.clickOnTheContactButton();
    }

    @When("I click on the nav bar about us button")
    public void iClickOnTheNavBarAboutUsButton() {
        navBar.clickOnTheAboutUsButton();
    }

    @When("I click on the nav bar log in button")
    public void iClickOnTheNavBarLogInButton() {
        navBar.clickOnTheLogInButton();
    }

    @When("I click on the nav bar sign up button")
    public void iClickOnTheNavBarSignUpButton() {
        navBar.clickOnTheSignUpButton();
    }

    @And("I click on the nav bar cart button")
    public void iClickOnTheNavBarCartButton() {
        navBar.clickOnTheCartButton();
    }

    @Then("I see a nav bar welcome message")
    public void iSeeANavBarWelcomeMessage() {
        String actualResult = navBar.getWelcomeMessage();
        String expectedResult = data.get("logInWelcomeMessage");
        assertEquals(actualResult, expectedResult, "Welcome log in message incorrect");
    }

    @And("I click on the nav bar log out button")
    public void iClickOnTheNavBarLogOutButton() {
        navBar.clickOnTheLogOutButton();
    }

    @Then("I see a sign up nav bar button")
    public void iSeeASignUpNavBarButton() {
        String actualResult = navBar.getSignUpButtonText().trim();
        String expectedResult = "Sign up";
        assertEquals(actualResult, expectedResult, "Sign up nav bar button not seen");
    }

    @And("I see a nav bar is displayed")
    public void iSeeANavBarIsDisplayed() {
        assertTrue(navBar.isDisplayed(), "Navigational bar is not displayed");
    }
}
