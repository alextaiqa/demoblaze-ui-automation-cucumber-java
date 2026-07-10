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

    @And("I click on the {string} device category on the main page")
    public void iClickOnTheCategoryOnTheMainPage(String category) {
        mainPage.clickOnTheDeviceCategoryButton(category);
    }

    @Then("I see no more than nine items in the {string} category on the main page")
    public void iSeeNoMoreThanNineItemsInTheDefaultCategoryOnTheMainPage(String category) {
        assertFalse(mainPage.isDeviceCategorySizeGreaterThanNine(),
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

    @And("I hover over the device category {string} button")
    public void iHoverOverTheDeviceCategoryButton(String button) {
        mainPage.hoverOverTheDeviceCategoryButton(button);
    }

    @Then("I see the device category {string} button changed color")
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

    @Then("I do not see a previous button in the device category")
    public void iDoNotSeeAPreviousButtonInTheDeviceCategories() {
        boolean isPreviousButtonDisplayed = mainPage.isDeviceCategoriesPreviousButtonDisplayed();
        assertFalse(isPreviousButtonDisplayed,
                "Device categories - 'previous' button is displayed on the first page");
    }

    @And("I go to the last page of the device category")
    public void iGoToTheLastPageOfTheDeviceCategory() {
        mainPage.goToTheLastPageOfTheDeviceCategory();
    }

    @Then("I do not see a next button in the {string} device category")
    public void iDoNotSeeANextButtonInTheDeviceCategory(String category) {
        boolean isNextButtonDisplayed = mainPage.isDeviceCategoriesNextButtonDisplayed();
        assertFalse(isNextButtonDisplayed,
                "Device categories - '" + category + "' - 'next' button is displayed on the last page");
    }

    @Then("I see that the {string} device category has no empty pages")
    public void iSeeThatTheDeviceCategoryHasNoEmptyPages(String category) {
        boolean isEmptyPageSeen = mainPage.isAnyDeviceCategoryPageEmpty();
        assertFalse(isEmptyPageSeen,
                "Device categories - empty page seen in the '" + category + "' device category");
    }

    @And("I see that the {string} device category has no duplicate items across all of its pages")
    public void iSeeTheDeviceCategoryHasNoDuplicateItemsAcrossItsPages(String category) {
        boolean hasDuplicateItems = mainPage.hasDeviceCategoryAnyDuplicateItems(category);
        assertFalse(hasDuplicateItems,
                "Device categories - duplicates seen in the '" + category + "' device category");
    }

    @Then("I see that items on the first page of the {string} device category redirect to a corresponding page")
    public void iSeeThatItemsOnTheFirstPageOfTheDeviceCategoryRedirectToACorrespondingPage(String category) {
        boolean itemsRedirectCorrectly =
                mainPage.itemsOnFirstPageOfDeviceCategoryRedirectToCorrespondingPage(category); //too long
        assertTrue(itemsRedirectCorrectly, "An item in the " + category + " did not redirect to a correct page");
    }

    @Then("I see that items on the first page of the {string} device category have a correct title on their pages")
    public void iSeeThatItemsOnTheFirstPageOfTheDeviceCategoryHaveACorrectTitleOnTheirPages(String category) {
        boolean itemsHaveCorrectTitlesOnTheirPages =
                mainPage.ItemsOnTheFirstPageOfTheDeviceCategoryHaveACorrectTitleOnTheirPages(category);
        assertTrue(itemsHaveCorrectTitlesOnTheirPages,
                "An item in the " + category + " did not redirect to a correct page");
    }
}
