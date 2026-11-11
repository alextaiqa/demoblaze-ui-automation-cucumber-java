package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class ContactModal extends BaseModal {

    /*=========================
        LOCATORS
    =========================*/
    private final By container = By.id("exampleModal");
    private final By header = By.cssSelector("#exampleModalLabel");
    private final By emailField = By.id("recipient-email");
    private final By nameField = By.id("recipient-name");
    private final By messageField = By.id("message-text");
    private final By confirmationButton = By.cssSelector("button[onclick='send()']");
    private final By closeButton =
            By.xpath("//div[@id='exampleModal']//button[normalize-space()='Close']");
    private final By xButton =
            By.xpath("//div[@id='exampleModal']//span[normalize-space()='×']");

    /*=========================
        CONSTRUCTOR
    =========================*/
    public ContactModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    /*=========================
        METHODS
    =========================*/
    public void enterValidEmail(String data) {
        enterFieldValue(emailField, data, "valid email");
    }

    public void enterValidName(String data) {
        enterFieldValue(nameField, data, "valid name");
    }

    public void enterValidMessage(String data) {
        enterFieldValue(messageField, data, "valid message");
    }

    public void enterInvalidNameWithSpecialCharacters(String data) {
        enterFieldValue(nameField, data, "invalid name - with special characters");
    }

    public void enterInvalidNameWithNumbers(String data) {
        enterFieldValue(nameField, data, "invalid name - with numbers");
    }

    public void enterInvalidEmailWithoutDomain(String data) {
        enterFieldValue(emailField, data, "invalid email - no domain");
    }

    public void enterInvalidEmailWithIncorrectDomain(String data) {
        enterFieldValue(emailField, data, "invalid email - with incorrect domain");
    }

    public void enterTwoHundredCharsIntoMessageField() {
        String data = "12345678910";
        enterFieldValue(messageField, data.repeat(20),
                "200 characters into the message field");
    }

    public void clickConfirmationButton() {
        clickButton(confirmationButton, "Send message");
    }

    public void clickCloseButton() {
        clickButton(closeButton, "Close");
    }

    public void clickXButton() {
        clickButton(xButton, "X");
    }

    public boolean isEmailFieldEmpty() {
        return isFieldEmpty(emailField, "email");
    }

    public boolean isNameFieldEmpty() {
        return isFieldEmpty(nameField, "name");
    }

    public boolean isMessageFieldEmpty() {
        return isFieldEmpty(messageField, "message");
    }

    public String getSuccessfulAlert() {
        return getAlertMessage("successfully sent");
    }

    public String getInvalidEmailAlert() {
        return getAlertMessage("incorrect email");
    }

    public String getInvalidNameAlert() {
        return getAlertMessage("incorrect name");
    }

    public String getTooManyCharactersAlert() {
        return getAlertMessage("too many characters");
    }

    //getters for base methods
    @Override
    protected By getContainerSelector() {
        return container;
    }

    @Override
    protected By getHeaderSelector() {
        return header;
    }

    @Override
    protected String getModalName() {
        return "'Contact'";
    }
}
