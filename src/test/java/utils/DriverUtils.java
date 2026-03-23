package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DriverUtils {

    private final WaitUtils waitUtils;

    public DriverUtils(WaitUtils waitUtils) {
        this.waitUtils = waitUtils;
    }

    public void openPage(String url) {
        DriverManager.getDriver().get(url); // work on this - waiting for page to load
    }

    public String getTitle() {
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

    public List<String> getTextFromMultipleElements(By selector) {
        List<WebElement> elements = getVisibleElements(selector); //getting elements
        List<String> textOfElements = new ArrayList<>(); //instantiating an array to store text of elements

        for (WebElement element : elements) {
            textOfElements.add(element.getText().trim()); //storing text of elements
        }
        return textOfElements;
    }

    public String getAlertText() {
        return waitUtils.waitForAlert().getText();
    }

    public String getAttribute(By selector, String attr) {
        return waitUtils.getVisibleElement(selector).getAttribute(attr);
    }

    public boolean isAttributeEmpty(By selector, String attr) {
        return getAttribute(selector, attr).isEmpty();
    }

    public void waitForAlertAndAccept() {
        try {
            waitUtils.waitForAlert().accept();
        } catch (TimeoutException ignored) {
        } //if it fails, then no alert is present - hooks are good to be closed
    }

    public boolean isElementDisplayed(By selector) {
        WebElement element = waitUtils.getVisibleElement(selector);
        return element != null && element.isDisplayed();
    }

    public boolean isElementInvisible(By selector) {
        return waitUtils.isElementInvisible(selector);
    }

    public List<WebElement> getVisibleElements(By selector) {
        return waitUtils.getVisibleElements(selector);
    }
}
