package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class CartPage extends BasePage {

    //selectors
    private final By placeOrderButton = By.cssSelector(".btn.btn-success");

    //constructor
    public CartPage(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods
    public boolean isPlaceOrderButtonDisplayed() {
        log.info("Checking if the 'Place Order' button is displayed");
        return driverUtils.isElementDisplayed(placeOrderButton);
    }

    //getters
    @Override
    public String getPageName() {
        return "Cart";
    }
}
