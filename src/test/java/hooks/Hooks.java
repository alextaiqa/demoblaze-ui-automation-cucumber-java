package hooks;

import driver.DriverManager;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import factory.DriverFactory;
import org.openqa.selenium.*;

import utils.DriverUtils;
import utils.ScreenshotUtils;


public class Hooks {

    private final TestContext testContext;
    private final DriverFactory driverFactory;
    private final DriverUtils driverUtils;
    private final ScreenshotUtils screenshotUtils;

    public Hooks(TestContext testContext, DriverFactory driverFactory, DriverUtils driverUtils,
                 ScreenshotUtils screenshotUtils) {
        this.testContext = testContext;
        this.driverFactory = driverFactory;
        this.driverUtils = driverUtils;
        this.screenshotUtils = screenshotUtils;
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
            try {
                System.out.println("Scenario failed: " + scenario.getName());
                handleAlertIfPresent();
                screenshotUtils.takeAScreenshot(scenario);
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
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
