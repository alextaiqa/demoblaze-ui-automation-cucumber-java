package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class SignUpModal extends BaseModal {

    //selectors
    private final By signUpModalContainerCSS = By.id("signInModal");
    private final By signUpModalHeaderCSS = By.id("signInModalLabel");
    private final By signUpModalUsernameFieldCSS = By.id("sign-username");
    private final By signUpModalPasswordFieldCSS = By.id("sign-password"); //should they be called CSS or CSS_ID or???
    private final By signUpModalConfirmationButtonXPath =
            By.xpath("//div[@id='signInModal']//button[normalize-space()='Sign up']");
    private final By signUpModalCloseButtonXpath =
            By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']");

    //constructor
    public SignUpModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods
    public void enterAValidUsername(String username) {
        log.info("Sign up - modal - entering a username");
        driverUtils.type(signUpModalUsernameFieldCSS, username);
    }

    public void enterAValidPassword(String password) {
        log.info("Sign up - modal - entering a password");
        driverUtils.type(signUpModalPasswordFieldCSS, password);
    }

    public void clickOnTheConfirmationButton() {
        log.info("Sign up - modal - clicking on the 'Sign up' button");
        driverUtils.click(signUpModalConfirmationButtonXPath);
    }

    public boolean seeSuccessfullySignedUpMessage() {
        log.info("Sign up - modal - verifying if a successful sign up message " +
                "appears when entering valid credentials");
        return driverUtils.getAlertText().equals("Sign up successful.");
    }

    public void enterAnExistingUsernameFor(String username) {
        log.info("Sign up - modal - entering an existing username");
        driverUtils.type(signUpModalUsernameFieldCSS, username);
    }

    public void enterAnExistingPasswordFor(String password) {
        log.info("Sign up - modal - entering an existing password");
        driverUtils.type(signUpModalPasswordFieldCSS, password);
    }

    public boolean seeAUserAlreadyExistsSignUpMessage() {
        log.info("Sign up - modal - verifying if a message " +
                "'This user already exist.' appears when signing up with an existing user");
        return driverUtils.getAlertText().equals("This user already exist.");
    }

    public void clickOnTheSignUpModalCloseButton() {
        log.info("Clicking on the 'Sign up' modal 'cancel' button");
        driverUtils.click(signUpModalCloseButtonXpath);
    }

    public boolean isUsernameFieldEmpty() {
        log.info("Sign up - modal - checking if the username field is empty");
        return driverUtils.isAttributeEmpty(signUpModalUsernameFieldCSS, "value");
    }

    public boolean isPasswordFieldEmpty() {
        log.info("Sign up - modal - checking if the password field is empty");
        return driverUtils.isAttributeEmpty(signUpModalPasswordFieldCSS, "value");
    }


    //methods for common behavior
    @Override
    protected By getModalContainer() {
        return signUpModalContainerCSS;
    }

    @Override
    protected By getHeaderLocator() {
        return signUpModalHeaderCSS;
    }

    @Override
    protected String getModalName() {
        return "'Sign up'";
    }
}
