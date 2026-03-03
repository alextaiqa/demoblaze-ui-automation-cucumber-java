package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class AboutUsModal extends BaseModal {

    //selectors


    //constructor
    public AboutUsModal(DriverUtils driverUtils) {
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
        return "'About us'";
    }

    //methods

    //test data getters - used for assertions in steps

}
