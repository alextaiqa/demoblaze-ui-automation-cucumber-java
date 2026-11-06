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
        enterFieldValue(usernameField, username,
                getModalName(), "username");
    }

    public void enterValidPassword(String password) {
        enterFieldValue(passwordField, password,
                getModalName(), "password");
    }

    public void clickOnTheConfirmationButton() {
        clickOnButton(confirmationButton,
                getModalName(), "Sign up");
    }

    public String getSuccessfullySignedUpMessage() {
        log.info("Sign up modal - getting a successful sign up message");
        return driverUtils.getAlertText();
    }

    public void enterExistingUsernameFor(String username) {
        enterFieldValue(usernameField, username,
                getModalName(), "existing username");
    }

    public void enterExistingPasswordFor(String password) {
        enterFieldValue(passwordField, password,
                getModalName(), "existing password");
    }

    public boolean seeUserAlreadyExistsMessage() {
        log.info("Sign up modal - verifying if a message " +
                "'This user already exist.' appears when signing up with an existing user");
        return driverUtils.getAlertText().equals("This user already exist.");
    }

    public void clickCloseButton() {
        clickOnButton(closeButton, getModalName(), "Cancel");
    }

    public boolean isUsernameFieldEmpty() {
        return isFieldEmpty(usernameField, getModalName(), "username");
    }

    public boolean isPasswordFieldEmpty() {
        return isFieldEmpty(passwordField, getModalName(), "password");
    }


    //methods for common behavior
    @Override
    protected By getModalContainer() {
        return modalContainer;
    }

    @Override
    protected By getHeaderLocator() {
        return modalHeader;
    }

    @Override
    protected String getModalName() {
        return "'Sign up'";
    }
}
