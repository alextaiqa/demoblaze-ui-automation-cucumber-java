package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;
import utils.TestData;

public class BaseModal {

    protected final DriverUtils driverUtils;
    protected final Logger log;
    protected final TestData data;

    public BaseModal(DriverUtils driverUtils, String filePath) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
        this.data = new TestData(filePath);
    }
}
