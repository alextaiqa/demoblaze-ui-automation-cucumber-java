package steps.components;

import io.cucumber.java.en.Then;
import pages.components.Footnote;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FootnoteSteps {

    private final Footnote footnote;

    public FootnoteSteps(Footnote footnote) {
        this.footnote = footnote;
    }

    @Then("I see a footnote is displayed")
    public void iSeeAFootnoteIsDisplayed() {

        ArrayList<String> expectedHeaders = new ArrayList<>(List.of("Get in Touch", "About Us", "About Us", "PRODUCT STORE"));
        assertTrue(footnote.isDisplayed(), "Footnote is not displayed");
        assertTrue(footnote.areFootnoteHeadersCorrect(expectedHeaders));
    }

    @Then("I see a copyright ribbon is displayed")
    public void iSeeACopyrightRibbonIsDisplayed() {
        assertTrue(footnote.isCopyrightRibbonDisplayed(), "Copyright ribbon is not displayed");
    }
}
