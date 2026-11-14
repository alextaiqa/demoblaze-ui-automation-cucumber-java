package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class LoginModal extends BaseModal {

    /*=========================
        LOCATORS
    =========================*/
    private final By loginModalContainerCSS = By.cssSelector("#logInModal");
    private final By loginModalHeaderCSS = By.cssSelector("#logInModalLabel");
    private final By usernameCSS = By.cssSelector("#loginusername");
    private final By passwordCSS = By.cssSelector("#loginpassword");
    private final By logInButtonCSS = By.cssSelector("button[onclick='logIn()']");
    private final By closeButtonXPath =
            By.xpath("//div[@id='logInModal']//button[normalize-space()='Close']");

    /*=========================
        CONSTRUCTOR
    =========================*/
    public LoginModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    /*=========================
        METHODS
    =========================*/
    public void enterValidUsername(String validUsername) {
        log.info("Log in modal - entering a correct username: {}", validUsername);
        driverUtils.type(usernameCSS, validUsername);
    }

    public void enterValidPassword(String correctPassword) {
        log.info("Log in modal - entering a correct password: {}", correctPassword);
        driverUtils.type(passwordCSS, correctPassword);
    }

    public void enterInvalidUsername(String incorrectUsername) {
        log.info("Log in modal - entering an incorrect username: {}", incorrectUsername);
        driverUtils.type(usernameCSS, incorrectUsername);
    }

    public void enterInvalidPassword(String incorrectPassword) {
        log.info("Log in modal - entering an incorrect password: {}", incorrectPassword);
        driverUtils.type(passwordCSS, incorrectPassword);
    }

    public void clickLoginButton() {
        log.info("Log in modal - clicking on the log in confirmation button");
        driverUtils.click(logInButtonCSS);

        waitForClosure();
    }

    public void clickClosingButton() {
        log.info("Log in modal - clicking on the closing button");
        driverUtils.click(closeButtonXPath);
    }

    public boolean isUsernameFieldEmpty() {
        log.info("Log in modal - checking if the username field is empty");
        return driverUtils.isAttributeEmpty(usernameCSS, "value");
    }

    public boolean isPasswordFieldEmpty() {
        log.info("Log in modal - checking if the password field is empty");
        return driverUtils.isAttributeEmpty(passwordCSS, "value");
    }

    public String getInvalidFieldsMessage() {
        return getAlertMessage("wrong username or password");
    }


    /*=========================
     GETTERS FOR COMMON METHODS
    =========================*/
    @Override
    protected By getContainerSelector() {
        return loginModalContainerCSS;
    }

    @Override
    protected By getHeaderSelector() {
        return loginModalHeaderCSS;
    }

    @Override
    protected String getModalName() {
        return "'Login'";
    }
}
