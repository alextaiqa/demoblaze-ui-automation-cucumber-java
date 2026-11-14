package models.login;

public class LoginModalData {

    /*=========================
        GLOBAL VARIABLES
    =========================*/
    private String header;

    private UserCredentials user1;
    private UserCredentials user2;
    private UserCredentials user3;
    private UserCredentials user4;
    private UserCredentials user5;

    private String invalidUsername;
    private String invalidPassword;
    private String invalidCredentialsAlert;
    private String emptyCredentialsAlert;


    /*=========================
        GETTERS AND SETTERS
    =========================*/
    public String geHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public UserCredentials getUser1() {
        return user1;
    }

    public void setUser1(UserCredentials user1) {
        this.user1 = user1;
    }

    public UserCredentials getUser2() {
        return user2;
    }

    public void setUser2(UserCredentials user2) {
        this.user2 = user2;
    }

    public UserCredentials getUser3() {
        return user3;
    }

    public void setUser3(UserCredentials user3) {
        this.user3 = user3;
    }

    public UserCredentials getUser4() {
        return user4;
    }

    public void setUser4(UserCredentials user4) {
        this.user4 = user4;
    }

    public UserCredentials getUser5() {
        return user5;
    }

    public void setUser5(UserCredentials user5) {
        this.user5 = user5;
    }

    public UserCredentials getUser(String user) {
        return switch (user) {
            case "user1" -> getUser1();
            case "user2" -> getUser2();
            case "user3" -> getUser3();
            case "user4" -> getUser4();
            case "user5" -> getUser5();
            default -> throw new IllegalArgumentException("Unknown user: " + user);
        };
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }

    public void setInvalidUsername(String invalidUsername) {
        this.invalidUsername = invalidUsername;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public void setInvalidPassword(String invalidPassword) {
        this.invalidPassword = invalidPassword;
    }

    public String getInvalidCredentialsAlert() {
        return invalidCredentialsAlert;
    }

    public void setInvalidCredentialsAlert(String invalidCredentialsAlert) {
        this.invalidCredentialsAlert = invalidCredentialsAlert;
    }

    public String getEmptyCredentialsAlert() {
        return emptyCredentialsAlert;
    }

    public void setEmptyCredentialsAlert(String emptyCredentialsAlert) {
        this.emptyCredentialsAlert = emptyCredentialsAlert;
    }
}
