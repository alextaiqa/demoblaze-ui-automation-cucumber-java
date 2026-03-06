package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // stores several drivers

    public static WebDriver getDriver() {
        return driver.get(); //get???? what is this???
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void unload() {
        driver.remove(); //removes a driver from a list of them
    }
}
