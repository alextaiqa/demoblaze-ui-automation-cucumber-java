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
        return getRegularWait().until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public Alert waitForAlert() {
        return getRegularWait().until(ExpectedConditions.alertIsPresent());
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
