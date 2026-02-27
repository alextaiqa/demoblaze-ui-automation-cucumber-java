package pages;

import org.slf4j.Logger; //???


import utils.DriverUtils;
import utils.LoggerUtil;

public class BasePage {
    protected DriverUtils driverUtils;
    protected final Logger log;

    protected BasePage(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
        this.log = LoggerUtil.getLogger(this.getClass());
    }

    public Logger getLog() {
        return log;
    }


    protected void openPage(String url){
        driverUtils.openPage(url);
    }

    protected String getPageTitle(String expectedTitle){
        return driverUtils.getPageTitle(expectedTitle);
    }

}
