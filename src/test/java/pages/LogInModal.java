package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;
import utils.TestData;

public class LogInModal extends BasePage {

    private final TestData data;

    private final By usernameCSS = By.cssSelector("#loginusername");
    private final By passwordCSS = By.cssSelector("#loginpassword");
    private final By logInButtonCSS = By.cssSelector("button[onclick='logIn()']");

    public LogInModal(DriverUtils driverUtils){
        super(driverUtils);
        this.data = new TestData("LogInModal.yaml");
    }

    public void enterACorrectUsername() {
        String correctUsername = data.get("username");
        log.info("Log in modal - entering a correct username: {}", correctUsername);
        driverUtils.type(usernameCSS, correctUsername);
    }

    public void enterACorrectPassword() {
        String correctPassword = data.get("password");
        log.info("Log in modal - entering a correct password: {}", correctPassword);
        driverUtils.type(passwordCSS, correctPassword);
    }

    public void enterAnIncorrectUsername() {
        String incorrectUsername = data.get("incorrectUsername");
        log.info("Log in modal - entering an incorrect username: {}", incorrectUsername);
        driverUtils.type(usernameCSS, incorrectUsername);
    }

    public void enterAnIncorrectPassword() {
        String incorrectPassword = data.get("incorrectPassword");
        log.info("Log in modal - entering an incorrect password: {}", incorrectPassword);
        driverUtils.type(passwordCSS, incorrectPassword);
    }

    public void clickOnTheLogInButton() {
        log.info("Clicking on the log in button inside the 'log in' modal");
        driverUtils.click(logInButtonCSS);
    }

    public String getLogInModalAlert() {
        log.info("Getting a log in modal alert message");
        return driverUtils.getAlertText().trim();
    }

    private String getIncorrectUsernameOrPasswordAlert() {
        return "";
    }

    private String getEmptyPasswordAndUsernameAlert() {
        return "";
    }
}
