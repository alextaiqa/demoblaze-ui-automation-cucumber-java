package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;

import java.util.Map;

public class NavBar {

    // =======================
// SELECTORS
// =======================
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

    // =======================
// MAP(RESOLVER)
// =======================
    //stores main nav bar buttons
    private final Map<String, By> navBarButtons = Map.of(
            "logo", logoID,
            "home", homeButtonXPath,
            "contact", contactButtonXPath,
            "about us", aboutUsButtonXpath,
            "cart", cartButtonID,
            "log in", logInButtonID,
            "log out", logOutButtonID,
            "sign up", signUpButtonID);

    // =======================
// GLOBAL VARIABLE
// =======================
    private final DriverUtils driverUtils;
    private final Logger log;

    // =======================
// CONSTRUCTOR
// =======================
    public NavBar(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    // =======================
// METHODS
// =======================
    public boolean isDisplayed() {
        log.info("Checking if the nav bar is displayed");
        return driverUtils.isElementDisplayed(navBarCSS);
    }

    //KEEP
    public void clickOnTheButton(String button) {
        log.info("Clicking on the '{}' button on the nav bar", button);
        driverUtils.click(getButtonSelector(button));
    }

    public String getWelcomeMessage() {
        log.info("Getting an actual welcome message for a logged in user");
        return driverUtils.getText(welcomeMessageID);
    }

    public String getSignUpButtonText() {
        log.info("Getting the 'Sign up' button text");
        return driverUtils.getText(signUpButtonID);
    }


    public void hoverOverTheButton(String button) {
        log.info("Hovering over the '{}' nav bar button", button);
        driverUtils.hoverOver(getButtonSelector(button)); //!!!!
    }

    public String getButtonColor(String button) {
        log.info("Getting the color of the '{}' button", button);
        return driverUtils.getCSSValue(getButtonSelector(button), "color");
    }

    // =======================
// HELPERS
// =======================
    //gets selectors of the main nav bar buttons
    private By getButtonSelector(String button) {
        button = button.toLowerCase();
        By selector = navBarButtons.get(button);
        if (selector == null) {
            throw new NoSuchElementException("Nav bar button not found. Received: '" + button + "'.");
        }
        return selector;
    }
}
