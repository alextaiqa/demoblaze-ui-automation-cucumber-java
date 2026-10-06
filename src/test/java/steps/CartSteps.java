package steps;

import context.TestContext;
import flows.ShoppingFlow;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import models.PurchaseData;
import pages.CartPage;
import utils.DataTableConverter;
import utils.TestDataGenerator;

import static org.testng.Assert.*;

public class CartSteps extends BaseSteps {

    private final CartPage cartPage;
    private final ShoppingFlow shoppingFlow;
    private final TestDataGenerator testDataGenerator;
    private final TestContext testContext;

    public CartSteps(CartPage cartPage, ShoppingFlow shoppingFlow, TestDataGenerator testDataGenerator,
                     TestContext testContext) {
        super("testdata/cartPage.yaml");
        this.cartPage = cartPage;
        this.shoppingFlow = shoppingFlow;
        this.testDataGenerator = testDataGenerator;
        this.testContext = testContext;
    }

    @Given("I open the cart page")
    public void iOpenTheCartPage() {
        String url = data.get("cartPageUrl");
        cartPage.open(url);
    }

    @Then("I see a correct title for the cart page")
    public void iSeeACorrectTitleForTheCartPage() {
        assertPageTitle(cartPage, cartPage.getPageName(), data.get("cartPageTitle"));
    }

    @Then("I see a place order button")
    public void iSeeAPlaceOrderButton() {
        assertTrue(cartPage.isPlaceOrderButtonDisplayed(), "'Place Order' button not found");
    }

    @When("I click on the place order button")
    public void iClickOnThePlaceOrderButton() {
        cartPage.clickOnThePlaceOrderButton();
    }

    @Then("I do not see a place order modal")
    public void iDoNotSeeAPlaceOrderModal() {
        assertFalse(cartPage.isPlaceOrderModalDisplayed(),
                "Clicking on the 'Place Order' button while the cart is empty opens the 'Place Order' modal");
    }

    @And("I add the {int} item in the {string} device category to the cart")
    public void iAddAnItemInTheDeviceCategoryToTheCart(int itemNumber, String deviceCategory) {
        shoppingFlow.addAnItemInTheDeviceCategoryToTheCart(deviceCategory, itemNumber);
    }

    @And("I enter a valid full name in the place order modal")
    public void iEnterAValidFullNameInThePlaceOrderModal() {
        cartPage.enterAValidFullNameInThePlaceOrderModal(testDataGenerator.generateFullName());
    }

    @And("I enter a valid country in the place order modal")
    public void iEnterAValidCountryInThePlaceOrderModal() {
        String randomCountry = testDataGenerator.generateCountry();
        testContext.set("country", randomCountry);
        cartPage.enterAValidCountryInThePlaceOrderModal(randomCountry);
    }

    @And("I enter a valid city in the place order modal")
    public void iEnterAValidCityInThePlaceOrderModal() {
        cartPage.enterAValidCityInThePlaceOrderModal(testDataGenerator.
                generateCity(testContext.get("country").toString()));
    }

    @And("I enter a valid credit card in the place order modal")
    public void iEnterAValidCreditCardInThePlaceOrderModal() {
        cartPage.enterAValidCreditCardInThePlaceOrderModal(testDataGenerator.generateCreditCardDigits());
    }

    @And("I enter a valid month in the place order modal")
    public void iEnterAValidMonthInThePlaceOrderModal() {
        cartPage.enterAValidMonthInThePlaceOrderModal(testDataGenerator.generateMonth()); //get current month?
    }

    @And("I enter a valid year in the place order modal")
    public void iEnterAValidYearInThePlaceOrderModal() {
        cartPage.enterAValidYearInThePlaceOrderModal(testDataGenerator.generateYear()); //get current month?
    }

    @And("I enter valid place order details in the cart modal")
    public void iEnterValidPlaceOrderDetailsInTheCartModal() {
        testContext.set();
        shoppingFlow.enterValidPlaceOrderDetailsInTheCartModal(testDataGenerator.generatePlaceOrderData());
    }

    @And("I click on the place order purchase button")
    public void iClickOnThePlaceOrderPurchaseButton() {
        cartPage.clickOnThePlaceOrderPurchaseButton();
    }

    @And("I successfully purchase the {int} item in the {string} category with valid credentials")
    public void iSuccessfullyPurchaseTheItemInTheDeviceCategoryWithValidCredentials(int itemNumber, String category) {
        shoppingFlow.successfullyPurchaseOneItemInTheDeviceCategoryWithValidCredentials(
                category, itemNumber, testDataGenerator.generatePlaceOrderData());
    }

    @Then("I see a purchase confirmation message")
    public void iSeeAPurchaseConfirmationMessage() {

        PurchaseData actualPurchaseData = cartPage.getPurchaseConfirmationMessage();
        PurchaseData expectedPurchaseData = (PurchaseData) testContext.get("purchaseData");

        String actualMessage = actualPurchaseData.getMessage();
        String expectedMessage = data.get("cartModalThankYouMessage");
        assertEquals(actualMessage, expectedMessage, "Cart - purchase confirmation - message is not correct");

        int actualAmount = actualPurchaseData.getTotal();
        int expectedAmount = expectedPurchaseData.getTotal(); //return total that you increment every time an item is added
        assertEquals(actualAmount, expectedAmount, "Cart - purchase confirmation - amount is not correct");

        String actualCardData = actualPurchaseData.getCardData();
        String expectedCardData = expectedPurchaseData.getCardData();
        assertEquals(String.valueOf(actualCardData), String.valueOf(expectedCardData),
                "Cart - purchase confirmation - card date is not correct");

        String actualName = actualPurchaseData.getName();
        String expectedName = expectedPurchaseData.getName();
        assertEquals(actualName, expectedName, "Cart - purchase confirmation - name is not correct");
    }

    @And("I add the following items to the cart:")
    public void iAddTheFollowingItemsToTheCart(DataTable dataTable) {
        shoppingFlow.addTheFollowingItemsToTheCart(DataTableConverter.getConvertedDataTable(dataTable));
    }

    @And("I successfully purchase the following items with valid credentials:")
    public void iSuccessfullyPurchaseTheFollowingItemsWithValidCredentials(DataTable dataTable) {
        shoppingFlow.successfullyPurchaseTheFollowingItemsWithValidCredentials(
                DataTableConverter.getConvertedDataTable(dataTable), testDataGenerator.generatePlaceOrderData());
    }

    @And("I make sure the cart is empty")
    public void iMakeSureTheCartIsEmpty() {
        cartPage.makeSureTheCartIsEmpty();
    }
}
