package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;
import utils.TestData;

public class LogInPage extends BasePage {

    private final By logInButtonCSS = By.cssSelector("#login2");
    private final By logInModalUsernameCSS = By.cssSelector("#loginusername");
    private final By logInModalPasswordCSS = By.cssSelector("#loginpassword");
    private final By logInModalLogInButtonCSS = By.cssSelector("button[onclick='logIn()']");

    public LogInPage(DriverUtils driverUtils){
        super(driverUtils);
    }

    public void clickOnTheLogInButton(){
        driverUtils.click(logInButtonCSS);
    }

    public void logInModalEnterACorrectUsername(){
        driverUtils.type(logInModalUsernameCSS, TestData.username);
    }

    public void logInModalEnterACorrectPassword(){
        driverUtils.type(logInModalPasswordCSS, TestData.password);
    }

    public void logInModalEnterAnIncorrectUsername(){
        driverUtils.type(logInModalUsernameCSS, TestData.incorrectUsername);
    }

    public void logInModalEnterAnIncorrectPassword(){
        driverUtils.type(logInModalPasswordCSS, TestData.incorrectPassword);
    }

    public void LogInModalClickOnTheLogInButton(){
        driverUtils.click(logInModalLogInButtonCSS);
    }

    public boolean isWrongUsernameAlertShown(){
        return driverUtils.getAlertText().contains(TestData.incorrectUsernameAlertMessage);
    }

    public boolean isWrongPasswordAlertShown(){
        return driverUtils.getAlertText().contains(TestData.incorrectPasswordAlertMessage);
    }

    public boolean isEmptyUsernameAndPasswordAlertShown(){
        return driverUtils.getAlertText().contains(TestData.emptyPasswordAndUsernameFieldsMessage);
    }
}
