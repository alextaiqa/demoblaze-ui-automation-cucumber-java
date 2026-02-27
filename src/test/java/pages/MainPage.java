package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;
import utils.TestData;

public class MainPage extends BasePage{

    private final By welcomeMessageCSS = By.cssSelector("#nameofuser");

    public MainPage(DriverUtils driverUtils){
        super(driverUtils);
    }

    public void openMainPage(){
        log.info("Opening the main page: " + TestData.homePageURL);
        openPage(TestData.homePageURL);
    }

    public String getAWelcomeMessage() { //update this - assert in the test
        return driverUtils.getText(welcomeMessageCSS);
    }

    public String getMainPageTitle(){
        return getPageTitle(TestData.mainPageTitle);
    }
}
