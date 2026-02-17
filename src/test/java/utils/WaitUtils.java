package utils;

import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final Duration REGULAR_WAIT = Duration.ofSeconds(10);
    private static final Duration ALERT_WAIT = Duration.ofSeconds(2);

    private WebDriverWait getWait(Duration timeout){
        WebDriver driver = DriverManager.getDriver();
        if (driver == null){
            throw new IllegalStateException("WebDriverWait - WaitUtils - getWait - Driver is null");
        }
        return new WebDriverWait(driver, timeout);
    }

    public WebElement getClickableElement(By selector) {
        return getWait(REGULAR_WAIT).until(ExpectedConditions.elementToBeClickable(selector));
    }

    public WebElement getVisibleElement(By selector) {
        return getWait(REGULAR_WAIT).until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public Alert waitForAlert() {
        return getWait(REGULAR_WAIT).until(ExpectedConditions.alertIsPresent());
    }

    //overloaded helper
    public Alert waitForAlert(Duration timeout) {
        return getWait(timeout).until(ExpectedConditions.alertIsPresent());
    }

    public void waitForAlertAndAccept() {
        try {
            waitForAlert(ALERT_WAIT).accept();
        } catch (TimeoutException ignored) {} //if it fails, then no alert is present - hooks are good to be closed
    }
}
