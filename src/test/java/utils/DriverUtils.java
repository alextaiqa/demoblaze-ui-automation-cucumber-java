package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

public class DriverUtils {

    private final WaitUtils waitUtils;

    public DriverUtils(WaitUtils waitUtils) {
        this.waitUtils = waitUtils;
    }

    public void openPage(String url) {
        DriverManager.getDriver().get(url); // work on this
    }

    public String getPageTitle(String expectedTitle){
        waitUtils.waitForPageTitle(expectedTitle);
        return DriverManager.getDriver().getTitle();
    }

    public void click(By selector) {
        waitUtils.getClickableElement(selector).click();
    }

    public void type(By selector, String data) {
        waitUtils.getClickableElement(selector).sendKeys(data);
    }

    public String getText(By selector) {
        return waitUtils.getVisibleElement(selector).getText();
    }

    public String getAlertText() {
        return waitUtils.waitForAlert().getText();
    }

    public void waitForAlertAndAccept() {
        waitUtils.waitForAlertAndAccept();
    }

    public boolean isAlertPresent() { //used for TC's
        try {
            waitUtils.waitForAlert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }

    }
}
