package factory;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public WebDriver createDriver() {

        Config config = new Config();

        String browser = System.getProperty("browser", config.getChromeBrowser()); //
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", String.valueOf(config.isHeadless())));

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }
                WebDriver chromeDriver = new ChromeDriver(chromeOptions);
                chromeDriver.manage().window().maximize();
                return chromeDriver;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }

                WebDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
                firefoxDriver.manage().window().maximize();
                return firefoxDriver;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

}
