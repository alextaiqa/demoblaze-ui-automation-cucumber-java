package steps;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.MainPage;
import utils.DriverUtils;

import static org.testng.Assert.*;

public class MainPageSteps extends BaseSteps {

    private final MainPage mainPage;
    private final TestContext testContext;

    public MainPageSteps(DriverUtils driverUtils, TestContext testContext) {
        super("testdata/mainPage.yaml");
        this.mainPage = new MainPage(driverUtils);
        this.testContext = testContext;
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

    @And("I click on the {string} category on the main page")
    public void iClickOnTheCategoryOnTheMainPage(String category) {
        mainPage.clickOnTheCategoryButton(category);
    }

    @Then("I see no more than nine items in the {string} category on the main page")
    public void iSeeNoMoreThanNineItemsInTheDefaultCategoryOnTheMainPage(String category) {
        assertTrue(mainPage.isDeviceCategorySizeGreaterThanNine(),
                "The '" + category + "' category has more than 9 items on the page");
    }

    @Then("I see the {int} image of the preview gallery on the main page")
    public void iSeeTheFirstImageOfThePreviewGalleryOnTheMainPage(int imageNumber) {
        assertTrue(mainPage.isPreviewGalleryImageDisplayed(imageNumber),
                "The image of the preview gallery - at position " + imageNumber + " - is not displayed");
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

    @And("I see the {string} in the device categories in a default color")
    public void iSeeTheButtonInTheDeviceCategoriesInADefaultColor(String button) {
        String buttonColor = mainPage.getButtonColor(button);
        testContext.set("color", buttonColor);


    }

    @And("I hover over the {string} in device categories")
    public void iHoverOverTheDeviceCategoryButton(String button) {
        mainPage.hoverOverTheDeviceCategoryButton(button);
    }

    @Then("I see the {string} device categories changed color")
    public void iSeeTheDeviceCategoryButtonChangedColor(String button) {
        String colorAfterHover = mainPage.getButtonColor(button);
        String colorBeforeHover = (String) testContext.get("color");
        assertNotEquals(colorAfterHover, colorBeforeHover,
                "Device categories - hover over button '" + button + "' - color did not change");
    }

    @And("I click on the {int} option of the preview gallery on the main page")
    public void iClickOnTheOptionOfThePreviewGalleryOnTheMainPage(int optionNumber) {
        mainPage.clickOnTheOptionOfThePreviewGallery(optionNumber);
    }

    @And("I do not see a previous button in the {string} device category")
    public void iDoNotSeeAPreviousButtonInTheDeviceCategories(String category) {
        boolean isPreviousButtonDisplayed = mainPage.isDeviceCategoriesPreviousButtonDisplayed(category);
        assertFalse(isPreviousButtonDisplayed,
                "Device categories - previous button is displayed on the first page");
    }
}
