package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class Item extends BasePage {

//    GLOBAL VARIABLES

    //    SELECTORS
    private final By addToCArtButtonXPath = By.xpath("//a[normalize-space()='Add to cart']");
    private final By itemNameHeaderCSS = By.cssSelector(".name");

    //    CONSTRUCTOR
    public Item(DriverUtils driverUtils) {
        super(driverUtils);
    }

/* =======================
       METHODS
       ======================= */

    public void clickOnTheAddToCartButton() {
        driverUtils.click(addToCArtButtonXPath);
    }

    /* =======================
       METHODS FOR COMMON BEHAVIOR
       ======================= */
    @Override
    protected String getPageName() {
        return driverUtils.getText(itemNameHeaderCSS);
    }
}
