package pages;

import utils.DriverUtils;

public class BasePage {
    protected DriverUtils driverUtils;

    protected BasePage(DriverUtils driverUtils){
        this.driverUtils = driverUtils;
    }
}
