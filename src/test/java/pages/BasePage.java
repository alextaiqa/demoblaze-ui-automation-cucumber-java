package pages;

import utils.DriverUtils;

public class BasePage {
    protected DriverUtils driverUtils;

    protected BasePage(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
    }

    protected void openPage(String url){
        driverUtils.openPage(url);
    }

    protected String getPageTitle(String expectedTitle){
        return driverUtils.getPageTitle(expectedTitle);
    }
}
