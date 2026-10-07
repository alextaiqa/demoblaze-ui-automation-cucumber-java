package flows;

import models.PlaceOrderData;
import models.PurchaseData;
import pages.CartPage;
import pages.Item;
import pages.MainPage;
import pages.components.NavBar;
import utils.DriverUtils;

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
    public int successfullyPurchaseOneItemInTheDeviceCategoryWithValidCredentials(String category,
                                                                       int itemNumber,
                                                                       PlaceOrderData placeOrderData) {
        int total = addAnItemInTheDeviceCategoryToTheCart(category, itemNumber);

        //a method that checks if gathered total matched total displayed? Maybe that should be a separate TC?
        // so stop gathering total across pages here? or maybe gather and then sweet alert?


        goToCartAndSuccessfullyPurchase(placeOrderData);

        return total;
    }

//    REVIEW ALL OF THESE. A WAY TO COMBINE THINGS?

    public int successfullyPurchaseTheFollowingItemsWithValidCredentials(List<Map<String, String>> categoriesAndItems,
                                                                          PlaceOrderData placeOrderData) {
        int total = addTheFollowingItemsToTheCart(categoriesAndItems);
        goToCartAndSuccessfullyPurchase(placeOrderData);

        return total;
    }

    public int addAnItemInTheDeviceCategoryToTheCart(String deviceCategory, int itemNumber) { //THIS IS CORRECT
        mainPage.clickOnAnItemInTheDeviceCategory(deviceCategory, itemNumber);
        int total = item.getPrice();
        item.clickOnTheAddToCartButton();
        driverUtils.waitForAlertAndAccept();
        return total;
    }

    public int addTheFollowingItemsToTheCart(List<Map<String, String>> categoriesAndItems) { //THIS IS CORRECT

        int total = 0;

        for (int i = 0; i < categoriesAndItems.size(); i++) {

            Map<String, String> row = categoriesAndItems.get(i);
            String category = row.get("category");
            int itemNumber = Integer.parseInt(row.get("item"));

            total += addAnItemInTheDeviceCategoryToTheCart(category, itemNumber);

            if (i < categoriesAndItems.size() - 1) {
                goToMain();
            }
        }
        return total;
    }

    public void goToCartAndSuccessfullyPurchase(PlaceOrderData placeOrderData) {
        goToCart();
        cartPage.clickOnThePlaceOrderButton();
        enterValidPlaceOrderDetailsInTheCartModal(placeOrderData);
        cartPage.clickOnThePlaceOrderPurchaseButton();
    }

    public void enterValidPlaceOrderDetailsInTheCartModal(PlaceOrderData placeOrderData) {
        cartPage.enterAValidFullNameInThePlaceOrderModal(placeOrderData.getFullName());
        cartPage.enterAValidCountryInThePlaceOrderModal(placeOrderData.getCountry());
        cartPage.enterAValidCityInThePlaceOrderModal(placeOrderData.getCity());
        cartPage.enterAValidCreditCardInThePlaceOrderModal(placeOrderData.getCreditCardDigits());
        cartPage.enterAValidMonthInThePlaceOrderModal(placeOrderData.getMonth());
        cartPage.enterAValidYearInThePlaceOrderModal(placeOrderData.getYear());
    }


    /*HELPERS*/
    private void goToCart() {
        navBar.clickOnTheButton("cart");
    }

    private void goToMain() {
        navBar.clickOnTheButton("home");
    }
}
