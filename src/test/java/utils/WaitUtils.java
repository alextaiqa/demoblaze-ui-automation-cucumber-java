package utils;

import config.Config;
import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

    //global variables
    private final Config config = new Config();
    private final Duration REGULAR_WAIT = config.getRegularWait();
    private final Duration ALERT_WAIT = config.getAlertWait();
    private final Logger log;

    //constructor
    public WaitUtils() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    //methods
    private WebDriverWait getWait(Duration timeout) { //base waiting method, timeout can be anything
        WebDriver driver = DriverManager.getDriver();
        if (driver == null){
            throw new IllegalStateException("WebDriverWait - WaitUtils - getWait - Driver is null");
        }
        return new WebDriverWait(driver, timeout);
    }

    private WebDriverWait getRegularWait() { //a wait method with 'regular' timing
        return getWait(REGULAR_WAIT);
    }

    private WebDriverWait getAlertWait() { //a wait method with 'alert' timing
        return getWait(ALERT_WAIT);
    }

    public WebElement getClickableElement(By selector) {
        try {
            return getRegularWait().until(ExpectedConditions.elementToBeClickable(selector));
        } catch (Exception e) {
            log.warn("Element with selector '{}' was not clickable. Waited for {} seconds.",
                    selector, REGULAR_WAIT.getSeconds());
            return null;
        }
    }

    public WebElement getVisibleElement(By selector) {
        try {
            return getRegularWait().until(ExpectedConditions.visibilityOfElementLocated(selector));
        } catch (TimeoutException e) {
            log.warn("Element with selector '{}' was not visible. Waited for {} seconds.",
                    selector, REGULAR_WAIT.getSeconds());
            return null;
        }
    }

    public List<WebElement> getVisibleElements(By selector) {
        try {
            return getRegularWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
        } catch (TimeoutException e) {
            log.warn("Elements with a selector '{}' were not visible. Waited for {} seconds.",
                    selector, REGULAR_WAIT.getSeconds());
            return null;
        }
    }

    public Boolean isElementInvisible(By selector) {
        try {
            return getRegularWait().until(ExpectedConditions.invisibilityOfElementLocated(selector));
        } catch (Exception e) {
            log.warn("Element with selector '{}' was visible. Waited for {} seconds.",
                    selector, REGULAR_WAIT.getSeconds());
            return false;
        }
    }

    public Alert waitForAlert() {
        try {
            return getAlertWait().until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            log.warn("No alert found. Waited for {} seconds.", REGULAR_WAIT.getSeconds());
            return null;
        }
    }
}
