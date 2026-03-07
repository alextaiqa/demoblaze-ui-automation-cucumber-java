package pages.components.modals;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;

public abstract class BaseModal {

    protected final DriverUtils driverUtils;
    protected final Logger log;

    //constructor
    public BaseModal(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    //getters for common methods
    protected abstract By getModalContainer();

    protected abstract By getHeaderLocator();

    protected abstract String getModalName(); //for logs

    //common methods
    public boolean isDisplayed() {
        log.info("Checking if the {} modal is displayed", getModalName());
        return driverUtils.isElementDisplayed(getModalContainer());
    }

    public String getHeaderText() {
        log.info("Getting the actual header of the {} modal", getModalName());
        return driverUtils.getText(getHeaderLocator());
    }
}
