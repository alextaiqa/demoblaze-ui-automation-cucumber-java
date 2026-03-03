package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;

public abstract class BasePage {

    //global vars
    protected DriverUtils driverUtils;
    protected final Logger log;

    //constructors
    protected BasePage(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    //getters
    protected abstract String getPageName();

    //methods
    public void open(String url) {
        log.info("Opening the {} page", getPageName());
        driverUtils.openPage(url);
    }

    public String getTitle(String expectedTitle) {
        log.info("Getting the actual title of the {} page", getPageName());
        return driverUtils.getTitle(expectedTitle);
    }

}
