package steps.components;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.components.NavBar;
import steps.BaseSteps;

public class NavBarSteps extends BaseSteps {

    private final NavBar navBar;

    //constructor
    public NavBarSteps(NavBar navBar) {
        super("testdata/navBar.yaml");
        this.navBar = navBar;
    }

    //steps
    @And("I click on the nav bar logo link")
    public void iClickOnTheNavBarLogoLink() {
        navBar.clickOnTheLogoLink();
    }

    @And("I click on the nav bar home link")
    public void iClickOnTheNavBarHomeLink() {
        navBar.clickOnTheHomeLink();
    }

    @When("I click on the nav bar contact link")
    public void iClickOnTheNavBarContactLink() {
        navBar.clickOnTheContactLink();
    }

    @When("I click on the nav bar about us link")
    public void iClickOnTheNavBarAboutUsLink() {
        navBar.clickOnTheAboutUsLink();
    }

    @When("I click on the nav bar log in link")
    public void iClickOnTheNavBarLogInLink() {
        navBar.clickOnTheLogInLink();
    }

    @When("I click on the nav bar sign up link")
    public void iClickOnTheNavBarSignUpLink() {
        navBar.clickOnTheSignUpLink();
    }

    @And("I click on the nav bar cart link")
    public void iClickOnTheNavBarCartLink() {
        navBar.clickOnTheCartLink();
    }

    @Then("I see a welcome message")
    public void iSeeAWelcomeMessage() {
        String actualResult = navBar.getWelcomeMessage();
        String expectedResult = data.get("logInWelcomeMessage");
        Assert.assertEquals(actualResult, expectedResult, "Welcome log in message incorrect");
    }

    @And("I click on the nav bar log out link")
    public void iClickOnTheNavBarLogOutLink() {
        navBar.clickOnTheLogOutLink();
    }
}
