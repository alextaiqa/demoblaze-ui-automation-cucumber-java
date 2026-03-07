package factory;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public WebDriver createDriver() {

        Config config = new Config();

        String browser = System.getProperty("browser", config.getBrowser());

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();

                if (config.isHeadless()) {
                    chromeOptions.addArguments("--headless=new");
                }
                chromeOptions.addArguments("--start-maximized");
                return new ChromeDriver(chromeOptions);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (config.isHeadless()) {
                    firefoxOptions.addArguments("--headless");
                }
                WebDriver driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                return driver;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

}
