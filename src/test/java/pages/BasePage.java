package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;
import utils.TestData;

public class BasePage {
    protected DriverUtils driverUtils;
    protected final Logger log;
    protected final TestData data;

    protected BasePage(DriverUtils driverUtils, String filePath) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
        this.data = new TestData(filePath);
    }

    protected void openPage(String url){
        driverUtils.openPage(url);
    }

    protected String getPageTitle(String expectedTitle, String pageName) {
        log.info("Getting the actual title of the {} page", pageName);
        return driverUtils.getPageTitle(expectedTitle);
    }

}
