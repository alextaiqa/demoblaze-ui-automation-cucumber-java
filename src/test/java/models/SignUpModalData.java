package models;

public class SignUpModalData {

    private String header;
    private String successfulSignUpMessage;
    private String userAlreadyExistsMessage;
    private String emptyFieldsMessage;

    public String getHeader() {
        return header;
    }

    public void setHeader(String signUpHeader) {
        this.header = signUpHeader;
    }

    public String getSuccessfulSignUpMessage() {
        return successfulSignUpMessage;
    }

    public void setSuccessfulSignUpMessage(String successfulSignUpMessage) {
        this.successfulSignUpMessage = successfulSignUpMessage;
    }

    public String getUserAlreadyExistsMessage() {
        return userAlreadyExistsMessage;
    }

    public void setUserAlreadyExistsMessage(String userAlreadyExistsMessage) {
        this.userAlreadyExistsMessage = userAlreadyExistsMessage;
    }

    public String getEmptyFieldsMessage() {
        return emptyFieldsMessage;
    }

    public void setEmptyFieldsMessage(String emptyFieldsMessage) {
        this.emptyFieldsMessage = emptyFieldsMessage;
    }
}
