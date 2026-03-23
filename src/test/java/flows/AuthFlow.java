package flows;

import pages.components.NavBar;
import pages.components.modals.LoginModal;

public class AuthFlow {

    //global vars
    private final NavBar navBar;
    private final LoginModal loginModal;


    //constructor
    public AuthFlow(NavBar navBar, LoginModal loginModal) {
        this.navBar = navBar;
        this.loginModal = loginModal;
    }


    //methods
    public void login(String username, String password) {
        navBar.clickOnTheLogInButton();
        loginModal.enterACorrectUsername(username);
        loginModal.enterACorrectPassword(password);
        loginModal.clickOnTheLogInButton();
    }
}
