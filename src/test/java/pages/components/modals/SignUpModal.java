package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class SignUpModal extends BaseModal {

    //selectors
    private final By modalContainer = By.id("signInModal");
    private final By modalHeader = By.id("signInModalLabel");
    private final By usernameField = By.id("sign-username");
    private final By passwordField = By.id("sign-password");
    private final By confirmationButton =
            By.xpath("//div[@id='signInModal']//button[normalize-space()='Sign up']");
    private final By closeButton =
            By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']");

    //constructor
    public SignUpModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods
    public void enterValidUsername(String username) {
        enterFieldValue(usernameField, username, "username");
    }

    public void enterValidPassword(String password) {
        enterFieldValue(passwordField, password, "password");
    }

    public void enterExistingUsernameFor(String username) {
        enterFieldValue(usernameField, username, "existing username");
    }

    public void enterExistingPasswordFor(String password) {
        enterFieldValue(passwordField, password, "existing password");
    }

    public String getSuccessfullySignedUpMessage() {
        return getAlertMessage("successful sign up");
    }

    public String getUserExistsMessage() {
        return getAlertMessage("user exists");
    }

    public String getEmptyFieldsMessage() {
        return getAlertMessage("empty fields");
    }

    public void clickOnTheConfirmationButton() {
        clickOnButton(confirmationButton, "Sign up");
    }

    public void clickCloseButton() {
        clickOnButton(closeButton, "Cancel");
    }

    public boolean isUsernameFieldEmpty() {
        return isFieldEmpty(usernameField, "username");
    }

    public boolean isPasswordFieldEmpty() {
        return isFieldEmpty(passwordField, "password");
    }

    //    methods for common behavior
    @Override
    protected By getContainerSelector() {
        return modalContainer;
    }

    @Override
    protected By getHeaderSelector() {
        return modalHeader;
    }

    @Override
    protected String getModalName() {
        return "'Sign up'";
    }
}
