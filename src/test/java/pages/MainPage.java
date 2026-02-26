package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
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

    public void confirmAWelcomeMessage(){ //update this - assert in the test
        String actualResult = driverUtils.getText(welcomeMessageCSS);
        String expectedResult = TestData.logInWelcomeMessage;

        Assert.assertEquals(actualResult, expectedResult, "Welcome log in message incorrect");
    }

    public String getMainPageTitle(){
        return getPageTitle(TestData.mainPageTitle);
    }
}
