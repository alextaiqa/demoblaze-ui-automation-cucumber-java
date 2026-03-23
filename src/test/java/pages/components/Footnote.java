package pages.components;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverUtils;

import java.util.ArrayList;
import java.util.List;

public class Footnote {

    //selectors
    private final By footnote = By.id("footc");
    private final By footnoteHeadersCSS = By.cssSelector("#footc h4");
    private final By copyRightRibbonCSS = By.cssSelector(".py-5.bg-inverse");

    //global variables
    private final DriverUtils driverUtils;
    private final Logger log;


    public Footnote(DriverUtils driverUtils) {
        this.driverUtils = driverUtils;
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    //methods
    public boolean isDisplayed() {
        log.info("Checking if the footnote is displayed");
        return driverUtils.isElementDisplayed(footnote);
    }

    //helpers
    public List<String> getFootnoteHeaders() {
        log.info("Getting actual footnote headers");
        return driverUtils.getTextFromMultipleElements(footnoteHeadersCSS);
    }

    public boolean isCopyrightRibbonDisplayed() {
        log.info("Checking if the copyright ribbon is displayed");
        return driverUtils.isElementDisplayed(copyRightRibbonCSS);
    }
}
