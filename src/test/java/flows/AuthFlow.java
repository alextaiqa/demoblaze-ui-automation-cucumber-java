package flows;

import pages.components.NavBar;
import pages.components.modals.LoginModal;

public class AuthFlow {

    /*=========================
        GLOBAL VARIABLES
    =========================*/
    private final NavBar navBar;
    private final LoginModal loginModal;


    /*=========================
        CONSTRUCTOR
    =========================*/
    public AuthFlow(NavBar navBar, LoginModal loginModal) {
        this.navBar = navBar;
        this.loginModal = loginModal;
    }

    /*=========================
        METHODS
    =========================*/
    public void login(String username, String password) {
        navBar.clickOnTheButton("log in");
        loginModal.enterValidUsername(username);
        loginModal.enterValidPassword(password);
        loginModal.clickLoginButton();
    }
}
