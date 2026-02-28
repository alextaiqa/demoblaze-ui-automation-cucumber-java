package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;

public class BasePage {
    protected DriverUtils driverUtils;
    protected final Logger log;

    protected BasePage(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    protected void openPage(String url){
        driverUtils.openPage(url);
    }

    protected String getPageTitle(String expectedTitle){
        return driverUtils.getPageTitle(expectedTitle);
    }

}
