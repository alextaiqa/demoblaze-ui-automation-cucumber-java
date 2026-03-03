package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class SignUpModal extends BaseModal {

    //selectors


    //constructor
    public SignUpModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods for common behavior
    @Override
    protected By getModalContainer() {
        return null;
    }

    @Override
    protected By getHeaderLocator() {
        return null;
    }

    @Override
    protected String getModalName() {
        return "'Sign up'";
    }

    //methods

    //test data getters - used for assertions in steps

}
