package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class LoginModal extends BaseModal {

    //selectors
    private final By loginModalCSS = By.cssSelector("#logInModal");
    private final By loginModalHeaderCSS = By.cssSelector("#logInModalLabel");
    private final By usernameCSS = By.cssSelector("#loginusername");
    private final By passwordCSS = By.cssSelector("#loginpassword");
    private final By logInButtonCSS = By.cssSelector("button[onclick='logIn()']");

    //constructor
    public LoginModal(DriverUtils driverUtils) {
        super(driverUtils, "testdata/loginModal.yaml");
    }

    //methods
    public void enterACorrectUsername() {
        String correctUsername = data.get("username");
        log.info("Log in modal - entering a correct username: {}", correctUsername);
        driverUtils.type(usernameCSS, correctUsername);
    }

    public void enterACorrectPassword() {
        String correctPassword = data.get("password");
        log.info("Log in modal - entering a correct password: {}", correctPassword);
        driverUtils.type(passwordCSS, correctPassword);
    }

    public void enterAnIncorrectUsername() {
        String incorrectUsername = data.get("incorrectUsername");
        log.info("Log in modal - entering an incorrect username: {}", incorrectUsername);
        driverUtils.type(usernameCSS, incorrectUsername);
    }

    public void enterAnIncorrectPassword() {
        String incorrectPassword = data.get("incorrectPassword");
        log.info("Log in modal - entering an incorrect password: {}", incorrectPassword);
        driverUtils.type(passwordCSS, incorrectPassword);
    }

    public void clickOnTheLogInButton() {
        log.info("Clicking on the log in button inside the 'log in' modal");
        driverUtils.click(logInButtonCSS);
    }

    public String getAlert() {
        log.info("Getting a log in modal alert message");
        return driverUtils.getAlertText().trim();
    }

    public String getActualHeader() {
        log.info("Getting the actual login modal header");
        return driverUtils.getText(loginModalHeaderCSS).trim();
    }

    public boolean isModalDisplayed() {
        log.info("Checking if login modal is displayed");
        return driverUtils.isElementDisplayed(loginModalCSS);
    }

    //test data getters - used for assertions in steps
    public String getIncorrectUsernameOrPasswordAlertData() {
        return data.get("incorrectUsernameOrPasswordAlert");
    }

    public String getEmptyPasswordAndUsernameAlertData() {
        return data.get("emptyPasswordAndUsernameAlert");
    }

    public String getExpectedHeaderData() {
        log.info("Getting the expected login modal header - from data");
        return data.get("loginModalHeader");
    }
}
