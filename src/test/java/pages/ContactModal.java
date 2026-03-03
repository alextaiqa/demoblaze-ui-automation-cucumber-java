package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class ContactModal extends BaseModal {

    //selectors
    private final By contactModalCSS = By.cssSelector("#exampleModal");
    private final By contactModalHeaderCSS = By.cssSelector("#exampleModalLabel");

    //constructor
    public ContactModal(DriverUtils driverUtils) {
        super(driverUtils, "testdata/contactModal.yaml");
    }

    //methods for common behavior
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

    //methods

    public String getActualHeader() {
        log.info("Getting the actual header of the 'Contact' modal");
        return driverUtils.getText(contactModalHeaderCSS).trim();
    }

    //test data getters - used for assertions in steps
//    public String getExpectedHeader() {
//        log.info("Getting the expected header of the 'Contact' modal");
//        return data.get("contactModalHeader");
//    }



}
