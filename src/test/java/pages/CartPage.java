package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class CartPage extends BasePage {

    //selectors
    private final By placeOrderButton = By.cssSelector(".btn.btn-success");
    private final By placeOrderModalContainer = By.id("orderModal");
    private final By fullNameModalFieldCSS = By.id("name");
    private final By countryModalFieldCSS = By.id("country");
    private final By cityModalFieldCSS = By.id("city");
    private final By creditCardModalFieldCSS = By.id("card");
    private final By monthModalFieldCSS = By.id("month");
    private final By yearModalFieldCSS = By.id("year");
    private final By purchaseModalButton =
            By.xpath("//button[normalize-space()='Purchase']");
    private final By closeModalButton =
            By.xpath("//div[@id='orderModal']//button[normalize-space()='Close']");
    private final By modalSweetAlertThankYouMessageXPath =
            By.xpath("//h2[normalize-space()='Thank you for your purchase!']");

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

    public void enterAValidFullNameInThePlaceOrderModal(String fullName) {
        log.info("Cart - 'Place order' modal - entering a valid full name: {}", fullName);
        driverUtils.type(fullNameModalFieldCSS, fullName);
    }

    public void enterAValidCountryInThePlaceOrderModal(String country) {
        log.info("Cart - 'Place order' modal - entering a valid country");
        driverUtils.type(countryModalFieldCSS, country);
    }

    public void enterAValidCityInThePlaceOrderModal(String city) {
        log.info("Cart - 'Place order' modal - entering a valid city");
        driverUtils.type(cityModalFieldCSS, city);
    }

    public void enterAValidCreditCardInThePlaceOrderModal(String creditCardDigits) {
        log.info("Cart - 'Place order' modal - entering valid credit card digits");
        driverUtils.type(creditCardModalFieldCSS, creditCardDigits);
    }

    public void enterAValidMonthInThePlaceOrderModal(String month) {
        log.info("Cart - 'Place order' modal - entering a valid month");
        driverUtils.type(monthModalFieldCSS, month);
    }

    public void enterAValidYearInThePlaceOrderModal(String year) {
        log.info("Cart - 'Place order' modal - entering a valid year");
        driverUtils.type(yearModalFieldCSS, year);
    }

    public void clickOnThePlaceOrderPurchaseButton() {
        log.info("Cart - 'Place order' modal - clicking on the 'Purchase' button");
        driverUtils.click(purchaseModalButton);
    }

    public String getPurchaseConfirmationMessage() {
        log.info("Cart - 'Place order' modal - getting a purchase confirmation message");
        return driverUtils.getText(modalSweetAlertThankYouMessageXPath);
    }


    //getters
    @Override
    public String getPageName() {
        return "Cart";
    }
}
