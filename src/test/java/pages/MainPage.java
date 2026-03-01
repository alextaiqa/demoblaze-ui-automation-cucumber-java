package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class MainPage extends BasePage{

    private final By logInButtonCSS = By.cssSelector("#login2");
    private final By welcomeMessageCSS = By.cssSelector("#nameofuser");

    public MainPage(DriverUtils driverUtils){
        super(driverUtils, "testdata/MainPage.yaml");
    }

    public void openMainPage(){
        log.info("Opening the main page: " + data.get("homePageURL"));
        openPage(data.get("homePageURL"));
    }

    public void clickOnTheLogInButton() {
        log.info("Clicking on the log in button on the main page");
        driverUtils.click(logInButtonCSS);
    }

    public String getWelcomeMessage() {
        return driverUtils.getText(welcomeMessageCSS);
    }

    public String getMainPageTitle(){
        return getPageTitle(data.get("mainPageTitle"));
    }

    //data getters

    public String getExpectedWelcomeMessage() {
        return data.get("logInWelcomeMessage");
    }

    public String getExpectedTitle() {
        return "";
    }
}
