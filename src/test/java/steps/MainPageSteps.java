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
                "The " + imageNumber + " image of the preview gallery is not displayed");
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
