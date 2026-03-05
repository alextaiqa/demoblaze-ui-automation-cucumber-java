package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class MainPage extends BasePage {

    //selectors
    private final By contactButtonXPath = By.xpath("//a[normalize-space()='Contact']");
    private final By aboutUsButtonXpath = By.xpath("//a[normalize-space()='About us']");
    private final By cartButtonCSS = By.id("cartur");
    private final By logInButtonCSS = By.id("login2");
    private final By signUpButtonCSS = By.id("signin2");
    private final By welcomeMessageCSS = By.id("nameofuser");

    //constructor
    public MainPage(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods
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
        driverUtils.click(cartButtonCSS);
    }

    public void clickOnTheLogInButton() {
        log.info("Clicking on the 'Log in' button on the nav bar");
        driverUtils.click(logInButtonCSS);
    }

    public void clickOnTheSignUpButton() {
        log.info("Clicking on the 'Sign up' button on the nav bar");
        driverUtils.click(signUpButtonCSS);
    }

    public String getWelcomeMessage() {
        log.info("Getting an actual welcome message for a logged in user");
        return driverUtils.getText(welcomeMessageCSS);
    }

    //methods for common behavior
    @Override
    public String getPageName() {
        return "'Main'";
    }
}
