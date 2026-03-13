package pages.components.modals;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class ContactModal extends BaseModal {

    //selectors
    private final By contactModalCSS = By.cssSelector("#exampleModal");
    private final By contactModalHeaderCSS = By.cssSelector("#exampleModalLabel");
    private final By contactModalEmailID = By.id("recipient-email");
    private final By contactModalNameID = By.id("recipient-name");
    private final By contactModalMessageID = By.id("message-text");
    private final By contactModalConfirmationButtonCSS = By.cssSelector("button[onclick='send()']");

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

    public String getAlertText() {
        log.info("Getting a 'Contact' modal alert message");
        return driverUtils.getAlertText();
    }

    public void enterAnInvalidEmailWithoutDomain(String data) {
        driverUtils.type(contactModalEmailID, data);
    }

    //getters for base methods
    @Override
    protected By getModalContainer() {
        return contactModalCSS;
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
