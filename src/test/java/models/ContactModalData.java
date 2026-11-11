package models;

public class ContactModalData {

    /*=========================
    FIELDS
=========================*/
    private String header;
    private String validEmail;
    private String validName;
    private String validMessage;
    private String successfulMessage;
    private String messageBoundaryAlert;
    private String invalidEmailAlert;
    private String invalidNameAlert;

    //should be generated?
    private String invalidEmailNoDomain;
    private String invalidEmailWithIncorrectDomain;
    private String invalidNameWithSpecialCharacters;
    private String invalidNameWithNumbers;

    /*=========================
        GETTERS & SETTERS
    =========================*/

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getValidEmail() {
        return validEmail;
    }

    public void setValidEmail(String validEmail) {
        this.validEmail = validEmail;
    }

    public String getValidName() {
        return validName;
    }

    public void setValidName(String validName) {
        this.validName = validName;
    }

    public String getValidMessage() {
        return validMessage;
    }

    public void setValidMessage(String validMessage) {
        this.validMessage = validMessage;
    }

    public String getSuccessfulMessage() {
        return successfulMessage;
    }

    public void setSuccessfulMessage(String successfulMessage) {
        this.successfulMessage = successfulMessage;
    }

    public String getMessageBoundaryAlert() {
        return messageBoundaryAlert;
    }

    public void setMessageBoundaryAlert(String messageBoundaryAlert) {
        this.messageBoundaryAlert = messageBoundaryAlert;
    }

    public String getInvalidEmailAlert() {
        return invalidEmailAlert;
    }

    public void setInvalidEmailAlert(String invalidEmailAlert) {
        this.invalidEmailAlert = invalidEmailAlert;
    }

    public String getInvalidNameAlert() {
        return invalidNameAlert;
    }

    public void setInvalidNameAlert(String invalidNameAlert) {
        this.invalidNameAlert = invalidNameAlert;
    }

    public String getInvalidEmailNoDomain() {
        return invalidEmailNoDomain;
    }

    public void setInvalidEmailNoDomain(String invalidEmailNoDomain) {
        this.invalidEmailNoDomain = invalidEmailNoDomain;
    }

    public String getInvalidEmailWithIncorrectDomain() {
        return invalidEmailWithIncorrectDomain;
    }

    public void setInvalidEmailWithIncorrectDomain(String invalidEmailWithIncorrectDomain) {
        this.invalidEmailWithIncorrectDomain = invalidEmailWithIncorrectDomain;
    }

    public String getInvalidNameWithSpecialCharacters() {
        return invalidNameWithSpecialCharacters;
    }

    public void setInvalidNameWithSpecialCharacters(String invalidNameWithSpecialCharacters) {
        this.invalidNameWithSpecialCharacters = invalidNameWithSpecialCharacters;
    }

    public String getInvalidNameWithNumbers() {
        return invalidNameWithNumbers;
    }

    public void setInvalidNameWithNumbers(String invalidNameWithNumbers) {
        this.invalidNameWithNumbers = invalidNameWithNumbers;
    }
}
