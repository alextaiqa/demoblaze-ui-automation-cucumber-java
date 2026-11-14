package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class LoginModal extends BaseModal {

    /*=========================
        LOCATORS
    =========================*/
    private final By container = By.cssSelector("#logInModal");
    private final By header = By.cssSelector("#logInModalLabel");
    private final By username = By.cssSelector("#loginusername");
    private final By password = By.cssSelector("#loginpassword");
    private final By logInButton = By.cssSelector("button[onclick='logIn()']");
    private final By closeButton =
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
        enterFieldValue(username, validUsername, "valid username");
    }

    public void enterValidPassword(String validPassword) {
        enterFieldValue(password, validPassword, "correct password");
    }

    public void enterInvalidUsername(String invalidUsername) {
        enterFieldValue(username, invalidUsername, "invalid username");
    }

    public void enterInvalidPassword(String invalidPassword) {
        enterFieldValue(password, invalidPassword, "invalid password");
    }

    public void clickLoginButton() {
        clickButton(logInButton, "Log in");
    }

    public void clickClosingButton() {
        clickButton(closeButton, "Close");
    }

    public boolean isUsernameFieldEmpty() {
        return isFieldEmpty(username, "username");
    }

    public boolean isPasswordFieldEmpty() {
        return isFieldEmpty(password, "password");
    }

    public String getInvalidFieldsMessage() {
        return getAlertMessage("wrong username or password");
    }

    /*=========================
     GETTERS FOR COMMON METHODS
    =========================*/
    @Override
    protected By getContainerSelector() {
        return container;
    }

    @Override
    protected By getHeaderSelector() {
        return header;
    }

    @Override
    protected String getModalName() {
        return "'Login'";
    }
}
