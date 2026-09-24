package flows;

import models.PlaceOrderData;
import pages.CartPage;
import pages.Item;
import pages.MainPage;
import pages.components.NavBar;
import utils.DriverUtils;

public class ShoppingFlow {

    /*GLOBAL VARIABLES*/
    NavBar navBar;
    MainPage mainPage;
    Item item;
    CartPage cartPage;
    DriverUtils driverUtils;

    /*CONSTRUCTOR*/
    public ShoppingFlow(NavBar navBar, MainPage mainPage, Item item, CartPage cartPage, DriverUtils driverUtils) {
        this.navBar = navBar;
        this.mainPage = mainPage;
        this.item = item;
        this.cartPage = cartPage;
        this.driverUtils = driverUtils;
    }

    /*METHODS*/
    public void addTheFirstItemInTheDeviceCategoryToTheCart(String deviceCategory) {
        mainPage.clickOnTheFirstItemInTheDeviceCategory(deviceCategory);
        item.clickOnTheAddToCartButton();
        driverUtils.waitForAlertAndAccept();
    }

    public void enterValidPlaceOrderDetailsInTheCartModal(PlaceOrderData placeOrderData) {
        cartPage.enterAValidFullNameInThePlaceOrderModal(placeOrderData.getFullName());
        cartPage.enterAValidCountryInThePlaceOrderModal(placeOrderData.getCountry());
        cartPage.enterAValidCityInThePlaceOrderModal(placeOrderData.getCity());
        cartPage.enterAValidCreditCardInThePlaceOrderModal(placeOrderData.getCreditCardDigits());
        cartPage.enterAValidMonthInThePlaceOrderModal(placeOrderData.getMonth());
        cartPage.enterAValidYearInThePlaceOrderModal(placeOrderData.getYear());
    }

    public void makeAPurchaseOfAFirstItemInTheDeviceCategoryWithValidCredentials(String category,
                                                                                 PlaceOrderData placeOrderData) {
        addTheFirstItemInTheDeviceCategoryToTheCart(category);
        goToCart();
        cartPage.clickOnThePlaceOrderButton();
        enterValidPlaceOrderDetailsInTheCartModal(placeOrderData);
        cartPage.clickOnThePlaceOrderPurchaseButton();
    }


    /*HELPERS*/
    private void goToCart() {
        navBar.clickOnTheButton("cart");
    }
}
