package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;
import utils.TestData;

public abstract class BaseModal {

    protected final DriverUtils driverUtils;
    protected final Logger log;

    protected abstract By getModalContainer();

    protected abstract By getHeaderLocator();

    protected abstract String getModalName(); //for logs

    //constructor
    public BaseModal(DriverUtils driverUtils, String filePath) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
        this.data = new TestData(filePath); //migrate all to steps !!!!
    }

    //methods
    public boolean isModalDisplayed() {
        log.info("Checking if the {} modal is displayed", getModalName());
        return driverUtils.isElementDisplayed(getModalContainer());
    }

    public String getHeaderText() {
        return driverUtils.getText(getHeaderLocator());
    }
}
