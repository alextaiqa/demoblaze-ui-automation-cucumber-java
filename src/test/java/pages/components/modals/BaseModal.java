package pages.components.modals;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;

public abstract class BaseModal {

    /*=========================
        FIELDS
    =========================*/
    protected final DriverUtils driverUtils;
    protected final Logger log;

    /*=========================
        CONSTRUCTOR
    =========================*/
    public BaseModal(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    /*=========================
     GETTERS FOR COMMON METHODS
    =========================*/
    protected abstract By getContainerSelector();

    protected abstract By getHeaderSelector();

    protected abstract String getModalName(); //for logs

    /*=========================
        METHODS
    =========================*/
    public boolean isDisplayed() {
        log.info("Checking if the {} modal is displayed", getModalName());
        return driverUtils.isElementDisplayed(getContainerSelector());
    }

    public boolean isNotDisplayed() {
        log.info("Checking if the {} modal is not displayed", getModalName());
        return driverUtils.isElementInvisible(getContainerSelector());
    }

    public String getHeader() {
        log.info("Getting the actual header of the {} modal", getModalName());
        return driverUtils.getText(getHeaderSelector());
    }

    protected String getAlertMessage(String message) {
        log.info("{} modal - getting a {} message", getModalName(), message);
        return driverUtils.getAlertText().trim();
    }

    public String getEmptyFieldsAlert() {
        return getAlertMessage("empty fields");
    }

    protected void enterFieldValue(By selector, String value, String valueName) {
        log.info("{} modal - entering {}", getModalName(), valueName);
        driverUtils.type(selector, value);
    }

    protected void clickButton(By selector, String modalButtonName) {
        log.info("{} modal - clicking on '{}' button", getModalName(), modalButtonName);
        driverUtils.click(selector);
    }

    protected boolean isFieldEmpty(By selector, String fieldName) {
        log.info("{} - modal - checking if the {} field is empty", getModalName(), fieldName);
        return driverUtils.isAttributeEmpty(selector, "value");
    }

    //modals with valid credentials require a short wait to close
//    public void waitForClosure() {
//        log.info("{} modal - waiting for it to close", getModalName());
//        if (!driverUtils.isElementInvisible(getContainerSelector())) {
//            throw new IllegalStateException(getModalName() + " modal did not close.");
//        }
//    }
}
