package pages;

import driver.DriverManager;
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
        DriverManager.getDriver().get(TestData.homePageURL);
    }

    public void confirmAWelcomeMessage(){
        String actualResult = driverUtils.getText(welcomeMessageCSS);
        String expectedResult = TestData.logInWelcomeMessage;

        Assert.assertEquals(actualResult, expectedResult, "Welcome log in message incorrect");
    }
}
