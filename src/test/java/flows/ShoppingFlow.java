package flows;

import pages.CartPage;
import pages.Item;
import pages.MainPage;
import pages.components.NavBar;

public class ShoppingFlow {

    //    GLOBAL VARIABLES
    NavBar navBar;
    MainPage mainPage;
    Item item;
    CartPage cartPage;


    //    CONSTRUCTOR
    public ShoppingFlow(NavBar navBar, MainPage mainPage, Item item, CartPage cartPage) {
        this.navBar = navBar;
        this.mainPage = mainPage;
        this.item = item;
        this.cartPage = cartPage;
    }

    //    METHODS
    public void addTheFirstItemInTheDeviceCategoryToTheCart(String deviceCategory) {
        mainPage.clickOnTheFirstItemInTheDeviceCategory(deviceCategory);
        item.clickOnTheAddToCartButton();
        navBar.acceptTheAlert();
    }

    public void enterValidPlaceOrderDetailsInTheCartModal() {

    }

//    HELPERS
}
