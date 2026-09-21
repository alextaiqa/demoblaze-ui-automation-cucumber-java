package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;
import utils.TestDataGenerator;

public class CartPage extends BasePage {

    //global selector

    //selectors
    private final By placeOrderButton = By.cssSelector(".btn.btn-success");
    private final By placeOrderModalContainer = By.id("orderModal");

    //constructor
    public CartPage(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods
    public boolean isPlaceOrderButtonDisplayed() {
        log.info("Checking if the 'Place Order' button is displayed");
        return driverUtils.isElementDisplayed(placeOrderButton);
    }

    public void clickOnThePlaceOrderButton() {
        log.info("Clicking on the 'Place Order' button");
        driverUtils.click(placeOrderButton);
    }

    public boolean isPlaceOrderModalDisplayed() {
        log.info("Checking if the 'Place Order' modal container is displayed");
        return driverUtils.isElementDisplayed(placeOrderModalContainer);
    }

    public void enterAValidNameInThePlaceOrderModal() {
//        log.info();
//        driverUtils.type(, );
    }

    public void enterAValidCountryInThePlaceOrderModal() {
//        log.info();
//        driverUtils.type(, );
    }

    public void enterAValidCityInThePlaceOrderModal() {

    }

    public void enterAValidCreditCardInThePlaceOrderModal() {

    }

    public void enterAValidMonthInThePlaceOrderModal() {

    }

    public void enterAValidYearInThePlaceOrderModal() {

    }

    public void clickOnThePlaceOrderPurchaseButton() {

    }

    public String getPurchaseConfirmationMessage() {
        return "";
    }


    //getters
    @Override
    public String getPageName() {
        return "Cart";
    }
}
