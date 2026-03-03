package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class SignUpModal extends BaseModal {

    //selectors
    private final By signUpModalContainerCSS = By.cssSelector("#signInModal");
    private final By signUpModalHeaderCSS = By.cssSelector("#signInModalLabel");

    //constructor
    public SignUpModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods


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
