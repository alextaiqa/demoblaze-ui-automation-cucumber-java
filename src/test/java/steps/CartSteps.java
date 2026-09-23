package steps;

import context.TestContext;
import flows.ShoppingFlow;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
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

    @And("I add the first item in the {string} device category to the cart")
    public void iAddTheFirstItemInTheDeviceCategoryToTheCart(String deviceCategory) {
        shoppingFlow.addTheFirstItemInTheDeviceCategoryToTheCart(deviceCategory);
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
        shoppingFlow.enterValidPlaceOrderDetailsInTheCartModal(testDataGenerator.generatePlaceOrderData());
    }

    @And("I click on the place order purchase button")
    public void iClickOnThePlaceOrderPurchaseButton() {
        cartPage.clickOnThePlaceOrderPurchaseButton();
    }

    @And("I make a purchase of a single item in the {string} category with valid credentials")
    public void iMakeAPurchaseOfASingleItemInTheDeviceCategoryWithValidCredentials(String category) {
        shoppingFlow.makeAPurchaseOfASingleItemInTheDeviceCategoryWithValidCredentials(category,
                testDataGenerator.generatePlaceOrderData());
    }

    @Then("I see a purchase confirmation message")
    public void iSeeAPurchaseConfirmationMessage() {
        String actualMessage = cartPage.getPurchaseConfirmationMessage(); // //h2[normalize-space()='Thank you for your purchase!']
        String expectedMessage = "";
        assertEquals(actualMessage, expectedMessage, "Cart - purchase confirmation - message is not correct");
    }
}
