package flows;

import models.PlaceOrderData;
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

    public void enterValidPlaceOrderDetailsInTheCartModal(PlaceOrderData placeOrderData) {
        cartPage.enterAValidFullNameInThePlaceOrderModal(placeOrderData.getFullName());
        cartPage.enterAValidCountryInThePlaceOrderModal(placeOrderData.getCountry());
        cartPage.enterAValidCityInThePlaceOrderModal(placeOrderData.getCity());
        cartPage.enterAValidCreditCardInThePlaceOrderModal(placeOrderData.getCreditCardDigits());
        cartPage.enterAValidMonthInThePlaceOrderModal(placeOrderData.getMonth());
        cartPage.enterAValidYearInThePlaceOrderModal(placeOrderData.getYear());
    }

    public void makeAPurchaseOfASingleItemInTheDeviceCategoryWithValidCredentials(
            String category, PlaceOrderData placeOrderData) {
        //click on the category
        //click on the item
        //click on the "add to cart"
        //accept the alert
        //click on the cart
        //click on the "place order" button
        //enter valid place order data
        //click on the "purchase" button
    }

    public void addAnItemToCart(String category, int item) {
        //click on the category
        //click on the item
        //click on the "add to cart"
        //accept the alert
    }

//    HELPERS
}
