package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class ContactModal extends BaseModal {

    //selectors
    private final By contactModalCSS = By.cssSelector("#exampleModal");
    private final By contactModalHeaderCSS = By.cssSelector("#exampleModalLabel");

    //constructor
    public ContactModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods

    //getters for common methods
    @Override
    protected By getModalContainer() {
        return contactModalCSS;
    }

    @Override
    protected By getHeaderLocator() {
        return contactModalHeaderCSS;
    }

    @Override
    protected String getModalName() {
        return "'Contact'";
    }
}
