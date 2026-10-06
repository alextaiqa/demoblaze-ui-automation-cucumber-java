package pages;

import models.PurchaseData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

import java.util.Arrays;
import java.util.List;

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
    private final By modalSweetAlertMessageCSS = By.cssSelector(".lead.text-muted");
    private final By itemsTableCSS = By.id("tbodyid tr");
    private final By firstDeleteItem = By.xpath(
            "(//tbody[@id='tbodyid']//a[@href='#'][normalize-space()='Delete']) [1]");

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

    public PurchaseData getPurchaseConfirmationMessage() {
        log.info("Cart - 'Place order' modal - getting a purchase confirmation message");
        String purchaseDetails = driverUtils.getText(modalSweetAlertMessageCSS);

        String message = driverUtils.getText(modalSweetAlertThankYouMessageXPath);
        int total = Integer.parseInt(
                getPurchaseDetail(purchaseDetails, "Amount").replace(" USD", ""));
        String cardData = getPurchaseDetail(purchaseDetails, "Card Number");
        String name = getPurchaseDetail(purchaseDetails, "Name");

        return new PurchaseData(message, total, cardData, name);
    }

    public void makeSureTheCartIsEmpty() {
        log.info("Cart - making sure it's empty");
        List<WebElement> items = driverUtils.getVisibleElements(itemsTableCSS);
        while (!items.isEmpty()) {
            driverUtils.click(firstDeleteItem);
        }
    }

    //HELPERS
    private String getPurchaseDetail(String purchaseData, String detailName) {
        return Arrays.stream(purchaseData.split("\\R"))
                .filter(line -> line.startsWith(detailName + ":"))
                .map(line -> line.substring(line.indexOf(":") + 1).trim())
                .findFirst()
                .orElseThrow();
    }


    //getters
    @Override
    public String getPageName() {
        return "Cart";
    }
}
