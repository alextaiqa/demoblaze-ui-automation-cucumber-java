package pages.components;

import org.openqa.selenium.By;
import pages.BasePage;
import utils.DriverUtils;

public class NavBar extends BasePage {

    //selectors
    private final By logoID = By.id("nava");
    private final By homeButtonXPath = By.xpath("//div[@id='navbarExample']//a[contains(normalize-space(),'Home')]");
    private final By contactButtonXPath = By.xpath("//a[normalize-space()='Contact']");
    private final By aboutUsButtonXpath = By.xpath("//a[normalize-space()='About us']");
    private final By cartButtonID = By.id("cartur");
    private final By logInButtonID = By.id("login2");
    private final By signUpButtonID = By.id("signin2");
    private final By welcomeMessageID = By.id("nameofuser");

    //constructor
    public NavBar(DriverUtils driverUtils) {
        super(driverUtils);
    }

    public void clickOnTheLogoLink() {
        log.info("Clicking on the nav bar logo");
        driverUtils.click(logoID);
    }

    public void clickOnTheHomeLink() {
        log.info("Clicking on the 'Home' button on the nav bar");
        driverUtils.click(homeButtonXPath);
    }

    public void clickOnTheContactLink() {
        log.info("Clicking on the 'Contact' button on the nav bar");
        driverUtils.click(contactButtonXPath);
    }

    public void clickOnTheAboutUsLink() {
        log.info("Clicking on the 'About us' button on the nav bar");
        driverUtils.click(aboutUsButtonXpath);
    }

    public void clickOnTheCartLink() {
        log.info("Clicking on the 'Cart' button on the nav bar");
        driverUtils.click(cartButtonID);
    }

    public void clickOnTheLogInLink() {
        log.info("Clicking on the 'Log in' button on the nav bar");
        driverUtils.click(logInButtonID);
    }

    public void clickOnTheSignUpLink() {
        log.info("Clicking on the 'Sign up' button on the nav bar");
        driverUtils.click(signUpButtonID);
    }

    public String getWelcomeMessage() {
        log.info("Getting an actual welcome message for a logged in user");
        return driverUtils.getText(welcomeMessageID);
    }

    //methods for common behavior
    @Override
    public String getPageName() {
        return "'Nav Bar Component'";
    }
}
