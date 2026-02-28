package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;
import utils.TestData;

public class MainPage extends BasePage{

    private final By logInButtonCSS = By.cssSelector("#login2");
    private final By welcomeMessageCSS = By.cssSelector("#nameofuser");

    public MainPage(DriverUtils driverUtils){
        super(driverUtils);
    }

    public void openMainPage(){
        log.info("Opening the main page: " + TestData.homePageURL);
        openPage(TestData.homePageURL);
    }

    public void clickOnTheLogInButton() {
        log.info("Clicking on the log in button on the main page");
        driverUtils.click(logInButtonCSS);
    }

    public String getAWelcomeMessage() { //update this - assert in the test
        return driverUtils.getText(welcomeMessageCSS);
    }

    public String getMainPageTitle(){
        return getPageTitle(TestData.mainPageTitle);
    }
}
