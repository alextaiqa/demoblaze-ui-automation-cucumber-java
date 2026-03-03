package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class MainPage extends BasePage {

    //selectors
    private final By contactButtonXPath = By.xpath("//a[normalize-space()='Contact']");
    private final By aboutUsButtonXpath = By.xpath("//a[normalize-space()='About us']");
    private final By logInButtonCSS = By.cssSelector("#login2");
    private final By signUpButtonCSS = By.cssSelector("#signin2");
    private final By welcomeMessageCSS = By.cssSelector("#nameofuser");

    //constructor
    public MainPage(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods

    public void clickOnTheContactButton() {
        log.info("Clicking on the contact button on the main page");
        driverUtils.click(contactButtonXPath);
    }

    public void clickOnTheAboutUsButton() {
        log.info("Clicking on the about us button on the main page");
        driverUtils.click(aboutUsButtonXpath);
    }

    public void clickOnTheLogInButton() {
        log.info("Clicking on the log in button on the main page");
        driverUtils.click(logInButtonCSS);
    }

    public void clickOnTheSignUpButton() {
        log.info("Clicking on the sign up button on the main page");
        driverUtils.click(signUpButtonCSS);
    }

    public String getWelcomeMessage() {
        log.info("Getting an actual welcome message for a logged in user");
        return driverUtils.getText(welcomeMessageCSS);
    }

    //methods for common behavior
    @Override
    protected String getPageName() {
        return "'Main'";
    }
}
