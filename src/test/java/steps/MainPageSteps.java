package steps;

import io.cucumber.java.en.*;
import pages.MainPage;
import utils.DriverUtils;

import static org.testng.Assert.*;

public class MainPageSteps extends BaseSteps {

    private final MainPage mainPage;

    public MainPageSteps(DriverUtils driverUtils) {
        super("testdata/mainPage.yaml");
        this.mainPage = new MainPage(driverUtils);
     }

    @Given("I open the main page")
    public void iOpenTheMainPage(){
        mainPage.open(data.get("homePageURL"));
    }

    @Then("I see a correct title for the main page")
    public void iSeeACorrectTitleForTheMainPage() {
        assertPageTitle(mainPage, mainPage.getPageName(), data.get("mainPageTitle"));
    }

    @Then("I see a categories container")
    public void iSeeACategoriesContainer() {
        assertTrue(mainPage.isCategoriesContainerDisplayed());
    }

    @And("I click on the Default category on the main page")
    public void iClickOnTheDefaultCategoryOnTheMainPage() {
        mainPage.clickOnTheDefaultCategoryButton();
    }

    @And("I click on the Phones category on the main page")
    public void iClickOnThePhonesCategoryOnTheMainPage() {
        mainPage.clickOnThePhonesCategoryButton();
    }

    @And("I click on the Laptops category on the main page")
    public void iClickOnTheLaptopsCategoryOnTheMainPage() {
        mainPage.clickOnTheLaptopsCategoryButton();
    }

    @And("I click on the Monitors category on the main page")
    public void iClickOnTheMonitorsCategoryOnTheMainPage() {
        mainPage.clickOnTheMonitorsCategoryButton();
    }


    @Then("I see no more than nine items in the Default category on the main page")
    public void iSeeNoMoreThanNineItemsInTheDefaultCategoryOnTheMainPage() {
        assertTrue(mainPage.isDeviceCategorySizeBiggerThanNine(),
                "The 'Default' category has more than 9 items on the page");
    }

    @Then("I see no more than nine items in the Phones category on the main page")
    public void iSeeNoMoreThanNineItemsInThePhonesCategoryOnTheMainPage() {
        assertTrue(mainPage.isDeviceCategorySizeBiggerThanNine(),
                "The 'Phones' category has more than 9 items on the page");
    }

    @Then("I see no more than nine items in the Laptops category on the main page")
    public void iSeeNoMoreThanNineItemsInTheLaptopsCategoryOnTheMainPage() {
        assertTrue(mainPage.isDeviceCategorySizeBiggerThanNine(),
                "The 'Laptops' category has more than 9 items on the page");
    }

    @Then("I see no more than nine items in the Monitors category on the main page")
    public void iSeeNoMoreThanNineItemsInTheMonitorsCategoryOnTheMainPage() {
        assertTrue(mainPage.isDeviceCategorySizeBiggerThanNine(),
                "The 'Monitors' category has more than 9 items on the page");
    }
}
