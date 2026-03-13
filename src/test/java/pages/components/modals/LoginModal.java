package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class LoginModal extends BaseModal {

    //selectors
    private final By loginModalContainerCSS = By.cssSelector("#logInModal");
    private final By loginModalHeaderCSS = By.cssSelector("#logInModalLabel");
    private final By usernameCSS = By.cssSelector("#loginusername");
    private final By passwordCSS = By.cssSelector("#loginpassword");
    private final By logInButtonCSS = By.cssSelector("button[onclick='logIn()']");

    //constructor
    public LoginModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods
    public void enterACorrectUsername(String correctUsername) {
        log.info("Log in modal - entering a correct username: {}", correctUsername);
        driverUtils.type(usernameCSS, correctUsername);
    }

    public void enterACorrectPassword(String correctPassword) {
        log.info("Log in modal - entering a correct password: {}", correctPassword);
        driverUtils.type(passwordCSS, correctPassword);
    }

    public void enterAnIncorrectUsername(String incorrectUsername) {
        log.info("Log in modal - entering an incorrect username: {}", incorrectUsername);
        driverUtils.type(usernameCSS, incorrectUsername);
    }

    public void enterAnIncorrectPassword(String incorrectPassword) {
        log.info("Log in modal - entering an incorrect password: {}", incorrectPassword);
        driverUtils.type(passwordCSS, incorrectPassword);
    }

    public void clickOnTheLogInButton() {
        log.info("Clicking on the log in button inside the 'log in' modal");
        driverUtils.click(logInButtonCSS);
    }

    public String getAlert() {
        log.info("Getting a 'Log in' modal alert message");
        return driverUtils.getAlertText().trim();
    }

    //getters for common methods
    @Override
    protected By getModalContainer() {
        return loginModalContainerCSS;
    }

    @Override
    protected By getHeaderLocator() {
        return loginModalHeaderCSS;
    }

    @Override
    protected String getModalName() {
        return "'Login'";
    }
}
