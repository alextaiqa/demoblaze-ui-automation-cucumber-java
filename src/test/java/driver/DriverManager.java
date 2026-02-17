package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // what is this??

    public static WebDriver getDriver() {
        return driver.get(); //get???? what is this???
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void unload() {
        driver.remove(); //what is this? What is it removing?
    }
}
