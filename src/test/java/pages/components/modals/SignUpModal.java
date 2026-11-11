package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class SignUpModal extends BaseModal {

    /*=========================
        LOCATORS
    =========================*/
    private final By container = By.id("signInModal");
    private final By header = By.id("signInModalLabel");
    private final By usernameField = By.id("sign-username");
    private final By passwordField = By.id("sign-password");
    private final By confirmationButton =
            By.xpath("//div[@id='signInModal']//button[normalize-space()='Sign up']");
    private final By closeButton =
            By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']");

    /*=========================
        CONSTRUCTOR
    =========================*/
    public SignUpModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    /*=========================
        METHODS
    =========================*/
    public void enterValidUsername(String username) {
        enterFieldValue(usernameField, username, "username");
    }

    public void enterValidPassword(String password) {
        enterFieldValue(passwordField, password, "password");
    }

    public void enterExistingUsername(String username) {
        enterFieldValue(usernameField, username, "existing username");
    }

    public void enterExistingPassword(String password) {
        enterFieldValue(passwordField, password, "existing password");
    }

    public String getSuccessfullySignedUpMessage() {
        return getAlertMessage("successful sign up");
    }

    public String getUserExistsMessage() {
        return getAlertMessage("user exists");
    }

    public void clickConfirmationButton() {
        clickButton(confirmationButton, "Sign up");
    }

    public void clickCloseButton() {
        clickButton(closeButton, "Cancel");
    }

    public boolean isUsernameFieldEmpty() {
        return isFieldEmpty(usernameField, "username");
    }

    public boolean isPasswordFieldEmpty() {
        return isFieldEmpty(passwordField, "password");
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
        return "'Sign up'";
    }
}
