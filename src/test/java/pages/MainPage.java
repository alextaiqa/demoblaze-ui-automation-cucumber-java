package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class MainPage extends BasePage{

    //selectors
    private final By contactButtonXPath = By.xpath("//a[normalize-space()='Contact']");
    private final By aboutUsButtonXpath = By.xpath("//a[normalize-space()='About us']");
    private final By logInButtonCSS = By.cssSelector("#login2");
    private final By signUpButtonCSS = By.cssSelector("#signin2");
    private final By welcomeMessageCSS = By.cssSelector("#nameofuser");

    //constructor
    public MainPage(DriverUtils driverUtils){
        super(driverUtils, "testdata/MainPage.yaml");
    }

    //methods
    public void open() {
        String url = data.get("homePageURL");
        log.info("Opening the main page. URL: {}", url);
        openPage(url);
    }

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

    public String getActualTitle() {
        return getPageTitle("STORE", "main");
    }

    //test data getters - used for assertions in steps

    public String getExpectedWelcomeMessage() {
        log.info("Getting an expected welcome message for a logged in user - from data");
        return data.get("logInWelcomeMessage");
    }

    public String getExpectedTitle() {
        log.info("Getting the expected title of the main page - from data");
        return data.get("mainPageTitle");
    }
}
