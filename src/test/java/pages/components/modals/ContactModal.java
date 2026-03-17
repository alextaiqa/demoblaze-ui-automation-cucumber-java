package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class ContactModal extends BaseModal {

    //selectors
    private final By contactModalID = By.id("exampleModal");
    private final By contactModalHeaderCSS = By.cssSelector("#exampleModalLabel");
    private final By contactModalEmailID = By.id("recipient-email");
    private final By contactModalNameID = By.id("recipient-name");
    private final By contactModalMessageID = By.id("message-text");
    private final By contactModalConfirmationButtonCSS = By.cssSelector("button[onclick='send()']");
    private final By contactModalClosingButtonXPath =
            By.xpath("//div[@id='exampleModal']//button[normalize-space()='Close']");
    private final By contactModalClosingXButtonXPath =
            By.xpath("//div[@id='exampleModal']//span[normalize-space()='×']");

    //constructor
    public ContactModal(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods
    public void enterAValidEmail(String data) {
        log.info("Entering a valid email in the 'Contact' modal");
        driverUtils.type(contactModalEmailID, data);
    }

    public void enterAValidName(String data) {
        log.info("Entering a valid name in the 'Contact' modal");
        driverUtils.type(contactModalNameID, data);
    }

    public void enterAValidMessage(String data) {
        log.info("Entering a valid message in the 'Contact' modal");
        driverUtils.type(contactModalMessageID, data);
    }

    public void clickOnTheConfirmationButton() {
        log.info("Clicking on the 'Contact' modal confirmation button");
        driverUtils.click(contactModalConfirmationButtonCSS);
    }

    public void enterAnInvalidEmailWithoutDomain(String data) {
        log.info("Entering an invalid email - with no domain");
        driverUtils.type(contactModalEmailID, data);
    }

    public void enterAnInvalidNameWithSpecialCharacters(String data) {
        log.info("Entering an invalid name - with special characters");
        driverUtils.type(contactModalNameID, data);
    }

    public void enterAnInvalidNameWithNumbers(String data) {
        log.info("Entering an invalid name - with numbers");
        driverUtils.type(contactModalNameID, data);
    }

    public void enterAnInvalidEmailWithIncorrectDomain(String data) {
        log.info("Entering an invalid email - with incorrect domain");
        driverUtils.type(contactModalEmailID, data);
    }

    public void enterTwoHundredCharactersIntoTheMessageField() {
        log.info("Entering 200 characters into the message field");
        String data = "12345678910";
        driverUtils.type(contactModalMessageID, data.repeat(20));
    }

    public void clickOnTheClosingButton() {
        log.info("Clicking on the closing button");
        driverUtils.click(contactModalClosingButtonXPath);
    }

    public void clickOnTheClosingXButton() {
        log.info("Clicking on the closing 'X' button");
        driverUtils.click(contactModalClosingXButtonXPath);
    }

    public boolean isEmailFieldEmpty() {
        log.info("Checking if the email field is empty");
        return driverUtils.isAttributeEmpty(contactModalEmailID, "value");
    }

    public boolean isNameFieldEmpty() {
        log.info("Checking if the name field is empty");
        return driverUtils.isAttributeEmpty(contactModalNameID, "value");
    }

    public boolean isMessageFieldEmpty() {
        log.info("Checking if the message field is empty");
        return driverUtils.isAttributeEmpty(contactModalMessageID, "value");
    }

    //getters for base methods
    @Override
    protected By getModalContainer() {
        return contactModalID;
    }

    @Override
    protected By getHeaderLocator() {
        return contactModalHeaderCSS;
    }

    @Override
    protected String getModalName() {
        return "'Contact'";
    }
}
