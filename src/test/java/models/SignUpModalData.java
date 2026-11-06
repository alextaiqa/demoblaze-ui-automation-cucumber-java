package models;

public class SignUpModalData {

    private String signUpHeader;
    private String successfulSignUpMessage;
    private String emptyFieldsMessage;

    public String getSignUpHeader() {
        return signUpHeader;
    }

    public void setSignUpHeader(String signUpHeader) {
        this.signUpHeader = signUpHeader;
    }

    public String getSuccessfulSignUpMessage() {
        return successfulSignUpMessage;
    }

    public void setSuccessfulSignUpMessage(String successfulSignUpMessage) {
        this.successfulSignUpMessage = successfulSignUpMessage;
    }

    public String getEmptyFieldsMessage() {
        return emptyFieldsMessage;
    }

    public void setEmptyFieldsMessage(String emptyFieldsMessage) {
        this.emptyFieldsMessage = emptyFieldsMessage;
    }
}
