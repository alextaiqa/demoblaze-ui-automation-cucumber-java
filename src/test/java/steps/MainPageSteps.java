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
        assertTrue(mainPage.isDeviceCategorySizeGreaterThanNine(),
                "The 'Default' category has more than 9 items on the page");
    }

    @Then("I see no more than nine items in the Phones category on the main page")
    public void iSeeNoMoreThanNineItemsInThePhonesCategoryOnTheMainPage() {
        assertTrue(mainPage.isDeviceCategorySizeGreaterThanNine(),
                "The 'Phones' category has more than 9 items on the page");
    }

    @Then("I see no more than nine items in the Laptops category on the main page")
    public void iSeeNoMoreThanNineItemsInTheLaptopsCategoryOnTheMainPage() {
        assertTrue(mainPage.isDeviceCategorySizeGreaterThanNine(),
                "The 'Laptops' category has more than 9 items on the page");
    }

    @Then("I see no more than nine items in the Monitors category on the main page")
    public void iSeeNoMoreThanNineItemsInTheMonitorsCategoryOnTheMainPage() {
        assertTrue(mainPage.isDeviceCategorySizeGreaterThanNine(),
                "The 'Monitors' category has more than 9 items on the page");
    }

    @Then("I see the first image of the preview gallery on the main page")
    public void iSeeTheFirstImageOfThePreviewGalleryOnTheMainPage() {
        assertTrue(mainPage.isPreviewGalleryImageDisplayed(1),
                "The first image of the preview gallery is not displayed");
    }

    @Then("I see the second image of the preview gallery on the main page")
    public void iSeeTheSecondImageOfThePreviewGalleryOnTheMainPage() {
        assertTrue(mainPage.isPreviewGalleryImageDisplayed(2),
                "The second image of the preview gallery is not displayed");
    }

    @Then("I see the third image of the preview gallery on the main page")
    public void iSeeTheThirdImageOfThePreviewGalleryOnTheMainPage() {
        assertTrue(mainPage.isPreviewGalleryImageDisplayed(3),
                "The third image of the preview gallery is not displayed");
    }

    @And("I click on the next button of the preview gallery on the main page")
    public void iClickOnTheNextButtonOfThePreviewGalleryOnTheMainPage() {
        mainPage.clickOnTheNextButtonOfThePreviewGallery();
    }

    @And("I click on the previous button of the preview gallery on the main page")
    public void iClickOnThePreviousButtonOfThePreviewGalleryOnTheMainPage() {
        mainPage.clickOnThePreviousButtonOfThePreviewGallery();
    }

    @Then("I see the item preview gallery has a correct amount of images on the main page")
    public void iSeeTheItemPreviewGalleryHasACorrectAmountOfImagesOnTheMainPage() {
        assertEquals(mainPage.itemPreviewGalleryHasACorrectAmountOfImages(), data.get("previewGalleryImagesCount"),
                "Preview gallery doesn't have a correct amount of images");
    }
}
