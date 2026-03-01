package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;
import utils.TestData;

public class BasePage {
    protected DriverUtils driverUtils;
    protected final Logger log;
    protected final TestData data;

    protected BasePage(DriverUtils driverUtils, String fileName) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
        this.data = new TestData(fileName);
    }

    protected void openPage(String url){
        driverUtils.openPage(url);
    }

    protected String getPageTitle(String expectedTitle){
        log.info("Getting the actual title of the page");
        return driverUtils.getPageTitle(expectedTitle);
    }

}
