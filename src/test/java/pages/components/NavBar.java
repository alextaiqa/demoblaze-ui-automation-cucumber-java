package pages.components;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;

public class NavBar {

    //selectors
    private final By navBarCSS = By.cssSelector(".navbar.navbar-toggleable-md.bg-inverse");
    private final By logoID = By.id("nava");
    private final By homeButtonXPath = By.xpath("//div[@id='navbarExample']//a[contains(normalize-space(),'Home')]");
    private final By contactButtonXPath = By.xpath("//a[normalize-space()='Contact']");
    private final By aboutUsButtonXpath = By.xpath("//a[normalize-space()='About us']");
    private final By cartButtonID = By.id("cartur");
    private final By logInButtonID = By.id("login2");
    private final By signUpButtonID = By.id("signin2");
    private final By welcomeMessageID = By.id("nameofuser");
    private final By logOutButtonID = By.id("logout2");

    //global variables
    private final DriverUtils driverUtils;
    private final Logger log;

    //constructor
    public NavBar(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    //methods
    public boolean isDisplayed() {
        log.info("Checking if the nav bar is displayed");
        return driverUtils.isElementDisplayed(navBarCSS);
    }

    public void clickOnTheLogo() {
        log.info("Clicking on the nav bar logo");
        driverUtils.click(logoID);
    }

    public void clickOnTheHomeButton() {
        log.info("Clicking on the 'Home' button on the nav bar");
        driverUtils.click(homeButtonXPath);
    }

    public void clickOnTheContactButton() {
        log.info("Clicking on the 'Contact' button on the nav bar");
        driverUtils.click(contactButtonXPath);
    }

    public void clickOnTheAboutUsButton() {
        log.info("Clicking on the 'About us' button on the nav bar");
        driverUtils.click(aboutUsButtonXpath);
    }

    public void clickOnTheCartButton() {
        log.info("Clicking on the 'Cart' button on the nav bar");
        driverUtils.click(cartButtonID);
    }

    public void clickOnTheLogInButton() {
        log.info("Clicking on the 'Log in' button on the nav bar");
        driverUtils.click(logInButtonID);
    }

    public void clickOnTheSignUpButton() {
        log.info("Clicking on the 'Sign up' button on the nav bar");
        driverUtils.click(signUpButtonID);
    }

    public String getWelcomeMessage() {
        log.info("Getting an actual welcome message for a logged in user");
        return driverUtils.getText(welcomeMessageID);
    }

    public void clickOnTheLogOutButton() {
        log.info("Clicking on the 'Log out' button on the nav bar");
        driverUtils.click(logOutButtonID);
    }

    public String getSignUpButtonText() {
        log.info("Getting the 'Sign up' button text");
        return driverUtils.getText(signUpButtonID);
    }
}
