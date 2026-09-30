package flows;

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
    public void addAnItemInTheDeviceCategoryToTheCart(String deviceCategory, Integer itemNumber) {
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

    public void purchaseOneItemInTheDeviceCategoryWithValidCredentials(String category,
                                                                       int itemNumber,
                                                                       PlaceOrderData placeOrderData) {
        addAnItemInTheDeviceCategoryToTheCart(category, itemNumber);
        goToCart();
        cartPage.clickOnThePlaceOrderButton();
        enterValidPlaceOrderDetailsInTheCartModal(placeOrderData);
        cartPage.clickOnThePlaceOrderPurchaseButton();
    }

    public void addTheFollowingItemsToTheCart(Map<String, Integer> categoriesAndItems) {
        List<String> categoriesKeys = new ArrayList<>(categoriesAndItems.keySet());

        for (int i = 0; i < categoriesAndItems.size(); i++) {

            String category = categoriesKeys.get(i);
            Integer itemNumber = categoriesAndItems.get(category);
            addAnItemInTheDeviceCategoryToTheCart(category, itemNumber);

            if (i == categoriesAndItems.size() - 1) {
                break;
            }
            goToMain();
        }
    }

    /*HELPERS*/
    private void goToCart() {
        navBar.clickOnTheButton("cart");
    }

    private void goToMain() {
        navBar.clickOnTheButton("homePageURL");
    }
}
