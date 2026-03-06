package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public WebDriver createDriver(){
        String browser = System.getProperty("browser", "chrome"); //this can be stored in a property file

        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions(); // what is this??
            options.addArguments("--start-maximized"); // what is this??
            return new ChromeDriver(options); //what is this??
        }

        throw new RuntimeException("Unsupported browser: " + browser);
        //firefox??
    }

}
