package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;
import utils.TestData;

public class LogInModal extends BasePage {

    private final By usernameCSS = By.cssSelector("#loginusername");
    private final By passwordCSS = By.cssSelector("#loginpassword");
    private final By logInButtonCSS = By.cssSelector("button[onclick='logIn()']");

    public LogInModal(DriverUtils driverUtils){
        super(driverUtils);
    }

    public void logInModalEnterACorrectUsername(){
        String correctUsername = TestData.username;
        log.info("Log in modal - entering a correct username: {}", correctUsername);
        driverUtils.type(usernameCSS, correctUsername);
    }

    public void logInModalEnterACorrectPassword(){
        String correctPassword = TestData.password;
        log.info("Log in modal - entering a correct password: {}", correctPassword);
        driverUtils.type(passwordCSS, correctPassword);
    }

    public void logInModalEnterAnIncorrectUsername(){
        String incorrectUsername = TestData.incorrectUsername;
        log.info("Log in modal - entering an incorrect username: {}", incorrectUsername);
        driverUtils.type(usernameCSS, incorrectUsername);
    }

    public void logInModalEnterAnIncorrectPassword(){
        String incorrectPassword = TestData.incorrectPassword;
        log.info("Log in modal - entering an incorrect password: {}", incorrectPassword);
        driverUtils.type(passwordCSS, incorrectPassword);
    }

    public void logInModalClickOnTheLogInButton() {
        log.info("Clicking on the log in button inside the 'log in' modal");
        driverUtils.click(logInButtonCSS);
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
