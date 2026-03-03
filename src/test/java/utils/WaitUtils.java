package utils;

import config.Config;
import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WaitUtils {

    private final Config config = new Config();
    private final Duration REGULAR_WAIT = config.getRegularWait();
    private final Duration ALERT_WAIT = config.getAlertWait();
    private final Logger log;

    public WaitUtils() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    private WebDriverWait getWait(Duration timeout){
        WebDriver driver = DriverManager.getDriver();
        if (driver == null){
            throw new IllegalStateException("WebDriverWait - WaitUtils - getWait - Driver is null");
        }
        return new WebDriverWait(driver, timeout);
    }

    private WebDriverWait getRegularWait(){
        return getWait(REGULAR_WAIT);
    }

    private WebDriverWait getAlertWait(){
        return getWait(ALERT_WAIT);
    }

    public void waitForPageTitle(String expectedTitle){
        try {
            getRegularWait().until(ExpectedConditions.titleContains(expectedTitle));
        } catch (TimeoutException e){
            throw new TimeoutException("Title does not contain " + expectedTitle, e);
        }
    }

    public WebElement getClickableElement(By selector) {
        return getRegularWait().until(ExpectedConditions.elementToBeClickable(selector));
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

    public Alert waitForAlert() {
        return getAlertWait().until(ExpectedConditions.alertIsPresent());
    }
}
