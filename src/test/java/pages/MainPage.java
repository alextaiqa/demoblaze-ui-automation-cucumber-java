package pages;

import org.openqa.selenium.By;
import utils.DriverUtils;

public class MainPage extends BasePage {

    //selectors

    private final By categoriesContainerID = By.id("contcont");
    private final By defaultCategoryButtonID = By.id("cat");
    private final By phonesCategoryButtonXPath =
            By.xpath("//a[@id='cat']/../a[contains(normalize-space(),'Phones')]");
    private final By laptopsCategoryButtonXPath =
            By.xpath("//a[@id='cat']/../a[contains(normalize-space(),'Laptops')]");
    private final By monitorsCategoryButtonXPath =
            By.xpath("//a[@id='cat']/../a[contains(normalize-space(),'Monitors')]");
    private final By deviceCategoryTableXPath = By.xpath("//div[@id='tbodyid']/div");


    //constructor
    public MainPage(DriverUtils driverUtils) {
        super(driverUtils);
    }

    //methods
    public boolean isCategoriesContainerDisplayed() {
        log.info("Checking if the 'Categories' container is displayed");
        return driverUtils.isElementDisplayed(categoriesContainerID);
    }

    public void clickOnTheDefaultCategoryButton() {
        log.info("Clicking on the 'Default' device category");
        driverUtils.click(defaultCategoryButtonID);
    }

    public void clickOnThePhonesCategoryButton() {
        log.info("Clicking on the 'Phones' device category");
        driverUtils.click(phonesCategoryButtonXPath);
    }

    public void clickOnTheLaptopsCategoryButton() {
        log.info("Clicking on the 'Laptops' device category");
        driverUtils.click(laptopsCategoryButtonXPath);
    }

    public void clickOnTheMonitorsCategoryButton() {
        log.info("Clicking on the 'Monitors' device category");
        driverUtils.click(monitorsCategoryButtonXPath);
    }

    public boolean isDeviceCategorySizeBiggerThanNine() {
        log.info("Checking if the category has more than 9 items");
        return driverUtils.getVisibleElements(deviceCategoryTableXPath).size() <= 9;
    }

    //methods for common behavior
    @Override
    public String getPageName() {
        return "'Main'";
    }
}
