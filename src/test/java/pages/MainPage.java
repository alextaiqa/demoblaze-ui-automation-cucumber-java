package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class MainPage extends BasePage{

    private final By logInButtonCSS = By.cssSelector("#login2");
    private final By welcomeMessageCSS = By.cssSelector("#nameofuser");

    public MainPage(DriverUtils driverUtils){
        super(driverUtils, "testdata/MainPage.yaml");
    }

    public void open() {
        String url = data.get("homePageURL");
        log.info("Opening the main page. URL: {}", url);
        openPage(url);
    }

    public void clickOnTheLogInButton() {
        log.info("Clicking on the log in button on the main page");
        driverUtils.click(logInButtonCSS);
    }

    public String getWelcomeMessage() {
        log.info("Getting an actual welcome message for a logged in user");
        return driverUtils.getText(welcomeMessageCSS);
    }

    public String getTitle() {
        log.info("Getting the actual title of the main page");
        return getPageTitle(data.get("mainPageTitle"));
    }

    //data getters

    public String getExpectedWelcomeMessage() {
        log.info("Getting an expected welcome message for a logged in user - from data");
        return data.get("logInWelcomeMessage");
    }

    public String getExpectedTitle() {
        log.info("Getting the expected title of the main page - from data");
        return data.get("mainPageTitle");
    }
}
