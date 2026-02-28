package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;
import utils.TestData;

public class LogInModal extends BasePage {

    private final By logInButtonCSS = By.cssSelector("#login2");
    private final By logInModalUsernameCSS = By.cssSelector("#loginusername");
    private final By logInModalPasswordCSS = By.cssSelector("#loginpassword");
    private final By logInModalLogInButtonCSS = By.cssSelector("button[onclick='logIn()']");

    public LogInModal(DriverUtils driverUtils){
        super(driverUtils);
    }

    public void clickOnTheLogInButton(){
        log.info("Clicking on the log in button on the main page");
        driverUtils.click(logInButtonCSS);
    }

    public void logInModalEnterACorrectUsername(){
        log.info("Log in modal - entering a correct username: " + TestData.username);
        driverUtils.type(logInModalUsernameCSS, TestData.username);
    }

    public void logInModalEnterACorrectPassword(){
        log.info("Log in modal - entering a correct password: " + TestData.password);
        driverUtils.type(logInModalPasswordCSS, TestData.password);
    }

    public void logInModalEnterAnIncorrectUsername(){
        log.info("Log in modal - entering an incorrect username: " + TestData.incorrectUsername);
        driverUtils.type(logInModalUsernameCSS, TestData.incorrectUsername);
    }

    public void logInModalEnterAnIncorrectPassword(){
        log.info("Log in modal - entering an incorrect password: " + TestData.incorrectPassword);
        driverUtils.type(logInModalPasswordCSS, TestData.incorrectPassword);
    }

    public void LogInModalClickOnTheLogInButton(){
        log.info("Clicking on the log in button inside the 'log in' modal");
        driverUtils.click(logInModalLogInButtonCSS);
    }

    public boolean isWrongUsernameAlertShown(){
        log.info("Waiting for an incorrect username alert");
        return driverUtils.getAlertText().contains(TestData.incorrectUsernameAlertMessage);
    }

    public boolean isEmptyUsernameAndPasswordAlertShown(){
        log.info("Waiting for an empty username AND password alert");
        return driverUtils.getAlertText().contains(TestData.emptyPasswordAndUsernameFieldsMessage);
    }
}
