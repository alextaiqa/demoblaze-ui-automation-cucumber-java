package steps.components;

import io.cucumber.java.en.Then;
import pages.components.Footnote;
import utils.TestData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FootnoteSteps {

    private final Footnote footnote;
    private final TestData data;

    public FootnoteSteps(Footnote footnote) {
        this.footnote = footnote;
        this.data = new TestData("testdata/footnote.yaml");
    }

    @Then("I see a footnote is displayed")
    public void iSeeAFootnoteIsDisplayed() {
        assertTrue(footnote.isDisplayed(), "Footnote is not displayed");

        List<String> actualHeaders = footnote.getFootnoteHeaders();
        List<String> expectedHeaders = data.getStringList("headers");
        assertEquals(actualHeaders, expectedHeaders, "Displayed footnote headers are incorrect");
    }

    @Then("I see a copyright ribbon is displayed")
    public void iSeeACopyrightRibbonIsDisplayed() {
        assertTrue(footnote.isCopyrightRibbonDisplayed(), "Copyright ribbon is not displayed");
    }
}
