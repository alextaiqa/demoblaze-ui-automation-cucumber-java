package flows;

import pages.components.NavBar;
import pages.components.modals.LoginModal;

public class AuthFlow {

    private final NavBar navBar;
    private final LoginModal loginModal;

    public AuthFlow(NavBar navBar, LoginModal loginModal) {
        this.navBar = navBar;
        this.loginModal = loginModal;
    }

    public void login(String username, String password) {
        navBar.clickOnTheLogInButton();
        loginModal.enterACorrectUsername(username);
        loginModal.enterACorrectPassword(password);
        loginModal.clickOnTheLogInButton();
    }
}
