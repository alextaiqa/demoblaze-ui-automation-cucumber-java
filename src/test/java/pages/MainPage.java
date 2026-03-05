package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class MainPage extends BasePage {

    //selectors

    private final By categoriesContainerID = By.id("contcont");

    //constructor
    public MainPage(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods
    public boolean isCategoriesContainerDisplayed() {
        log.info("Checking if the 'Categories' container is displayed");
        return driverUtils.isElementDisplayed(categoriesContainerID);
    }

    //methods for common behavior
    @Override
    public String getPageName() {
        return "'Main'";
    }
}
