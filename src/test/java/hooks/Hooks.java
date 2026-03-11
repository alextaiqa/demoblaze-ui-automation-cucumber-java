package hooks;

import driver.DriverManager;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import factory.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Label;
import org.openqa.selenium.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import utils.DriverUtils;
import utils.ScreenshotUtils;


public class Hooks {

    private final TestContext testContext;
    private final DriverFactory driverFactory;
    private final DriverUtils driverUtils;
    private final ScreenshotUtils screenshotUtils;
    private final Logger log;

    public Hooks(TestContext testContext, DriverFactory driverFactory, DriverUtils driverUtils,
                 ScreenshotUtils screenshotUtils) {
        this.testContext = testContext;
        this.driverFactory = driverFactory;
        this.driverUtils = driverUtils;
        this.screenshotUtils = screenshotUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
    }


    @BeforeClass
    public void setBrowserLabel() {
        String browser = System.getProperty("browser", "chrome");

        Label label = new Label();
        label.setName("browser");
        label.setValue(browser);

        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.getLabels().add(label);
        });
    }

    @Before
    public void setup() {
        WebDriver driver = driverFactory.createDriver();
        DriverManager.setDriver(driver);
        testContext.setDriver(driver);
    }

    @After
    public void tearDown(Scenario scenario) { //Cucumber passes the currently running scenario
        if (scenario.isFailed()) {
            log.error("Scenario failed: {}", scenario.getName());
            try {
                handleAlertIfPresent(); //a screenshot cannot be taken if an alert is present
                screenshotUtils.takeAScreenshot(scenario);
            } catch (Exception e) {
                log.error("Hooks - teardown - error while taking a screenshot", e);
            }
        } else {
            log.info("Scenario passed: {}", scenario.getName());
        }
        quitDriver();
    }

    //helpers
    private void handleAlertIfPresent() {
        driverUtils.waitForAlertAndAccept();
    }

    private void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
