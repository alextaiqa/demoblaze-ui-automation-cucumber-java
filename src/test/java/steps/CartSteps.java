package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

import static org.testng.Assert.*;

public class CartSteps extends BaseSteps {

    private final CartPage cartPage;

    public CartSteps(CartPage cartPage) {
        super("testdata/cartPage.yaml");
        this.cartPage = cartPage;
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
}
