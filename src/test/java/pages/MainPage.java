package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.DriverUtils;

import java.util.Map;

public class MainPage extends BasePage {

// =======================
// SELECTORS
// =======================

    // PREVIEW GALLERY / CAROUSEL
    /*
     * Sidenote:
     * - Only one image is "active" at a time.
     * - After clicking on the next/previous button, the carousel transitions asynchronously - needs time.
     * - The "active" class/state is updated only after the transition is completed.
     *
     * The selectors in this category depend on the "active" state to determine the currently visible slide.
     * Removing or changing these selectors or carousel-related methods would break navigation assertions.
     */
    @SuppressWarnings("FieldCanBeLocal")
    private final String PREVIEW_GALLERY_SLIDE_BY_INDEX_ACTIVE_XPATH =
            "(//div[contains(@class,'carousel-item')])[%s][contains(@class,'active')]";
    private final By previewGalleryImagesContainerXPath = By.xpath("//div[@id='contcar']//descendant::img");
    private final By previousButtonOfThePreviewGalleryCSS = By.cssSelector(".carousel-control-prev");
    private final By nextButtonOfThePreviewGalleryCSS = By.cssSelector(".carousel-control-next");

    // DEVICE CATEGORIES
    private final By categoriesContainerID = By.id("contcont");
    private final By defaultCategoryButtonID = By.id("cat");
    private final By phonesCategoryButtonXPath =
            By.xpath("//a[@id='cat']/../a[contains(normalize-space(),'Phones')]");
    private final By laptopsCategoryButtonXPath =
            By.xpath("//a[@id='cat']/../a[contains(normalize-space(),'Laptops')]");
    private final By monitorsCategoryButtonXPath =
            By.xpath("//a[@id='cat']/../a[contains(normalize-space(),'Monitors')]");
    private final By deviceCategoryTableXPath = By.xpath("//div[@id='tbodyid']/div");

// =======================
// MAP (RESOLVER)
// =======================

    private final Map<String, By> deviceCategoriesButtons = Map.of(
            "default", defaultCategoryButtonID,
            "phones", phonesCategoryButtonXPath,
            "laptops", laptopsCategoryButtonXPath,
            "monitors", monitorsCategoryButtonXPath
    );

    // =======================
// CONSTRUCTOR
// =======================
    public MainPage(DriverUtils driverUtils) {
        super(driverUtils);
    }

// =======================
// METHODS
// =======================

    // PREVIEW GALLERY / CAROUSEL
    public boolean isPreviewGalleryImageDisplayed(int slideIndex) {
        //A selector to validate that the expected slide is "active" based on its position in the carousel
        By activeSlideImage = By.xpath(String.format(PREVIEW_GALLERY_SLIDE_BY_INDEX_ACTIVE_XPATH, slideIndex));

        log.info("Checking if the '{}' image of the preview gallery is displayed", slideIndex);
        return driverUtils.isElementDisplayed(activeSlideImage);
    }

    public void clickOnTheNextButtonOfThePreviewGallery() {
        log.info("Clicking on the 'next' button of the preview gallery");
        driverUtils.click(nextButtonOfThePreviewGalleryCSS);
    }

    public void clickOnThePreviousButtonOfThePreviewGallery() {
        log.info("Clicking on the 'previous' button of the preview gallery");
        driverUtils.click(previousButtonOfThePreviewGalleryCSS);
    }

    public String itemPreviewGalleryHasACorrectAmountOfImages() {
        log.info("Checking if a preview gallery has a correct amount of images");
        return String.valueOf(driverUtils.getPresentElements(previewGalleryImagesContainerXPath).size());
    }

    // DEVICE CATEGORIES
    public boolean isCategoriesContainerDisplayed() {
        log.info("Checking if the 'Categories' container is displayed");
        return driverUtils.isElementDisplayed(categoriesContainerID);
    }

    public void clickOnTheCategoryButton(String category) {
        log.info("Clicking on the '{}' device category", category);
        driverUtils.click(getCategoryButton(category));
    }

    public boolean isDeviceCategorySizeGreaterThanNine() {
        log.info("Checking if the category has more than 9 items");
        return driverUtils.getVisibleElements(deviceCategoryTableXPath).size() <= 9;
    }

    // =======================
// HELPERS
// =======================
    private By getCategoryButton(String category) {
        category = category.toLowerCase();
        By selector = deviceCategoriesButtons.get(category);
        if (selector == null) {
            throw new NoSuchElementException("No such category found. Category received: " + category);
        }
        return selector;
    }

    // =======================
// METHODS FOR COMMON BEHAVIOR
// =======================
    @Override
    public String getPageName() {
        return "'Main'";
    }
}
