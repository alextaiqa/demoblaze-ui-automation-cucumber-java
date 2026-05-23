package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

import java.util.List;
import java.util.Map;

public class MainPage extends BasePage {

    /* =======================
       SELECTORS
       ======================= */

    // PREVIEW GALLERY / CAROUSEL

    /* Sidenote:
     * - Only one image is "active" at a time.
     * - After clicking on the next/previous button, the carousel transitions asynchronously - needs time.
     * - The "active" class/state is updated only after the transition is completed.
     *
     * The selectors in this category depend on the "active" state to determine the currently visible slide.
     * Removing or changing these selectors or carousel-related methods would break navigation assertions.
     */
    @SuppressWarnings("FieldCanBeLocal") //responsible for multiple images via %s
    private final String PREVIEW_GALLERY_SLIDE_BY_INDEX_ACTIVE_XPATH =
            "(//div[contains(@class,'carousel-item')])[%s][contains(@class,'active')]";
    private final By previewGalleryImagesContainerXPath = By.xpath("//div[@id='contcar']//descendant::img");
    private final By previousButtonOfThePreviewGalleryCSS = By.cssSelector(".carousel-control-prev");
    private final By nextButtonOfThePreviewGalleryCSS = By.cssSelector(".carousel-control-next");

    @SuppressWarnings("FieldCanBeLocal") //responsible for multiple options via %s
    private final String OPTIONS_OF_THE_PREVIEW_GALLERY = "#carouselExampleIndicators li[data-slide-to='%s']";


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
    private final By deviceCategoriesPreviousButtonID = By.id("prev2");
    private final By deviceCategoriesNextButtonID = By.id("next2");

    /* =======================
       MAP (RESOLVER)
       ======================= */

    private final Map<String, By> deviceCategoriesButtons = Map.of(
            "default", defaultCategoryButtonID,
            "phones", phonesCategoryButtonXPath,
            "laptops", laptopsCategoryButtonXPath,
            "monitors", monitorsCategoryButtonXPath
    );

    /* =======================
       CONSTRUCTOR
       ======================= */
    public MainPage(DriverUtils driverUtils) {
        super(driverUtils);
    }

    /* =======================
       METHODS
       ======================= */

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

    public void clickOnTheOptionOfThePreviewGallery(int optionNumber) {
        By selector = By.cssSelector(String.format(OPTIONS_OF_THE_PREVIEW_GALLERY, optionNumber - 1));
        driverUtils.click(selector);
    }

    // DEVICE CATEGORIES
    public boolean isCategoriesContainerDisplayed() {
        log.info("Checking if the 'Categories' container is displayed");
        return driverUtils.isElementDisplayed(categoriesContainerID);
    }

    public void clickOnTheDeviceCategoryButton(String category) {
        log.info("Clicking on the '{}' device category", category);
        driverUtils.click(getCategoryButton(category));
    }

    public boolean isDeviceCategorySizeGreaterThanNine() {
        log.info("Checking if the category has more than 9 items");
        return getDeviceCategoryItems().size() > 9;
    }

    public void hoverOverTheDeviceCategoryButton(String button) {
        log.info("Hovering over the {} in the device categories", button);
        driverUtils.hoverOver(getCategoryButton(button));
    }

    public String getButtonColor(String button) {
        log.info("Getting the color of the button '{}'", button);
        return driverUtils.getCSSValue(getCategoryButton(button), "color");
    }

    public boolean isDeviceCategoriesPreviousButtonDisplayed() {
        log.info("Checking if the previous button in the device categories is displayed");
        return driverUtils.isElementDisplayed(deviceCategoriesPreviousButtonID);
    }

    public boolean isDeviceCategoriesNextButtonDisplayed() {
        log.info("Checking if the next button in the device categories is displayed");
        return driverUtils.isElementDisplayed(deviceCategoriesNextButtonID);
    }

    public void clickOnTheNextDeviceCategoryButton() {
        log.info("Clicking on the 'next' button of the device category");
        driverUtils.click(deviceCategoriesNextButtonID);
    }

    public void clickOnThePreviousDeviceCategoryButton() {
        log.info("Clicking on the 'previous' button of the device category");
        driverUtils.click(deviceCategoriesPreviousButtonID);
    }

    public void goToTheLastPageOfTheDeviceCategory() {
        log.info("Getting to the last page of the device category");
        while (isDeviceCategoriesNextButtonDisplayed()) {
            if (getDeviceCategoryItems().size() < 9) {
                break;
            }
            goToTheNextDeviceCategoryPage();
        }
    }

    public boolean isAnyDeviceCategoryPageEmpty() {
        log.info("Checking if any device category page is empty");
        while (true) {
            if (getDeviceCategoryItems().isEmpty()) {
                return true;
            }
            if (!isDeviceCategoriesNextButtonDisplayed()) {
                return false;
            }
            goToTheNextDeviceCategoryPage();
        }
    }

    /* =======================
       HELPERS
       ======================= */
    private By getCategoryButton(String category) {
        category = category.toLowerCase();
        By selector = deviceCategoriesButtons.get(category);
        if (selector == null) {
            throw new NoSuchElementException("No such category found. Category received: " + category);
        }
        return selector;
    }

    private void goToTheNextDeviceCategoryPage() {
        WebElement oldTable = driverUtils.getVisibleElement(deviceCategoryTableXPath);
        clickOnTheNextDeviceCategoryButton();
        driverUtils.waitForElementToBecomeStale(oldTable);
    }

    private List<WebElement> getDeviceCategoryItems() {
        return driverUtils.getVisibleElements(deviceCategoryTableXPath);
    }

    /* =======================
       METHODS FOR COMMON BEHAVIOR
       ======================= */
    @Override
    public String getPageName() {
        return "'Main'";
    }
}
