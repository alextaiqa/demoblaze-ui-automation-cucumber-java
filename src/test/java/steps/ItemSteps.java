package steps;

import io.cucumber.java.en.*;
import pages.Item;

import static org.testng.Assert.*;

public class ItemSteps {

    //    GLOBAL VARIABLES
    Item item;

    //    CONSTRUCTOR
    public ItemSteps(Item item) {
        this.item = item;
    }

    //    METHODS
    @And("I click on the add to cart button")
    public void iClickOnTheAddToCartButton() {
        item.clickOnTheAddToCartButton();
    }
}
