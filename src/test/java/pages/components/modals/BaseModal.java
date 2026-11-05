package pages.components.modals;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;

public abstract class BaseModal {

    // =======================
// GLOBAL VARIABLES
// =======================
    protected final DriverUtils driverUtils;
    protected final Logger log;

    // =======================
// CONSTRUCTOR
// =======================
    public BaseModal(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    // =======================
// GETTERS FOR COMMON METHODS
// =======================
    protected abstract By getModalContainer();

    protected abstract By getHeaderLocator();

    protected abstract String getModalName(); //for logs

    // =======================
// METHODS
// =======================
    public boolean isDisplayed() {
        log.info("Checking if the {} modal is displayed", getModalName());
        return driverUtils.isElementDisplayed(getModalContainer());
    }

    public boolean isNotDisplayed() {
        log.info("Checking if the {} modal is not displayed", getModalName());
        return driverUtils.isElementInvisible(getModalContainer());
    }

    public String getHeaderText() {
        log.info("Getting the actual header of the {} modal", getModalName());
        return driverUtils.getText(getHeaderLocator());
    }

    public String getAlertText() {
        log.info("Getting a {} modal alert message", getModalName());
        return driverUtils.getAlertText().trim();
    }


    // create commonly used methods here to reduce dupes

    protected void enterFieldValue(By selector, String value, String modalName, String valueName) {
        log.info("{} modal - entering {}", modalName, valueName);
        driverUtils.type(selector, value);
    }

    protected void clickOnButton(By selector, String modalName, String modalButtonName) {
        log.info("{} modal - clicking on '{}' button", modalName, modalButtonName);
        driverUtils.click(selector);
    }

    protected boolean isFieldEmpty(By selector, String modalName, String fieldName) {
        log.info("{} - modal - checking if the {} field is empty", modalName, fieldName);
        return driverUtils.isAttributeEmpty(selector, "value");
    }

    private void waitForClosure() {
        log.info("{} modal - waiting for it to close", getModalName());
        if (!driverUtils.isElementInvisible(getModalContainer())) {
            throw new IllegalStateException(getModalName() + " modal did not close.");
        }
    }
}
