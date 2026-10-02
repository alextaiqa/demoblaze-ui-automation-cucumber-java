package flows;

import io.cucumber.java.it.Ma;
import io.cucumber.java.sl.In;
import models.PlaceOrderData;
import pages.CartPage;
import pages.Item;
import pages.MainPage;
import pages.components.NavBar;
import utils.DriverUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void addAnItemInTheDeviceCategoryToTheCart(String deviceCategory, int itemNumber) {
        mainPage.clickOnAnItemInTheDeviceCategory(deviceCategory, itemNumber);
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

    public void successfullyPurchaseOneItemInTheDeviceCategoryWithValidCredentials(String category,
                                                                       int itemNumber,
                                                                       PlaceOrderData placeOrderData) {
        addAnItemInTheDeviceCategoryToTheCart(category, itemNumber);
        goToCartAndSuccessfullyPurchase(placeOrderData);

    }

    public void successfullyPurchaseTheFollowingItemsWithValidCredentials(List<Map<String, String>> categoriesAndItems,
                                                                          PlaceOrderData placeOrderData) {
        addTheFollowingItemsToTheCart(categoriesAndItems);
        goToCartAndSuccessfullyPurchase(placeOrderData);
    }

    public void addTheFollowingItemsToTheCart(List<Map<String, String>> categoriesAndItems) {

        for (int i = 0; i < categoriesAndItems.size(); i++) {

            Map<String, String> row = categoriesAndItems.get(i);
            String category = row.get("category");
            int itemNumber = Integer.parseInt(row.get("item"));

            addAnItemInTheDeviceCategoryToTheCart(category, itemNumber);

            if (i < categoriesAndItems.size() - 1) {
                goToMain();
            }
        }
    }

    public void goToCartAndSuccessfullyPurchase(PlaceOrderData placeOrderData) {
        goToCart();
        cartPage.clickOnThePlaceOrderButton();
        enterValidPlaceOrderDetailsInTheCartModal(placeOrderData);
        cartPage.clickOnThePlaceOrderPurchaseButton();
    }


    /*HELPERS*/
    private void goToCart() {
        navBar.clickOnTheButton("cart");
    }

    private void goToMain() {
        navBar.clickOnTheButton("home");
    }
}
