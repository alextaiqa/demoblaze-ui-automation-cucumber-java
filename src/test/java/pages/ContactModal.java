package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class ContactModal extends BasePage {

    //selectors
    private final By contactModalCSS = By.cssSelector("#exampleModal");
    private final By contactModalHeaderCSS = By.cssSelector("#exampleModalLabel");

    //constructor
    public ContactModal(DriverUtils driverUtils) {
        super(driverUtils, "testdata/contactModal.yaml");
    }

    //methods
    public boolean isDisplayed() {
        log.info("Checking if the contact modal is displayed");
        return driverUtils.isElementDisplayed(contactModalCSS);
    }

    public String getActualHeader() {
        log.info("Getting the actual header of the 'Contact' modal");
        return driverUtils.getText(contactModalHeaderCSS).trim();
    }

    //test data getters - used for assertions in steps
    public String getExpectedHeader() {
        log.info("Getting the expected header of the 'Contact' modal");
        return data.get("contactModalHeader");
    }


}
