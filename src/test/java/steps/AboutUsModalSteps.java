package steps;

import io.cucumber.java.en.Then;
import pages.AboutUsModal;

import static org.testng.Assert.*;

public class AboutUsModalSteps extends BaseSteps {

    private final AboutUsModal aboutUsModal;

    public AboutUsModalSteps(AboutUsModal aboutUsModal) {
        super("testdata/aboutUsModal.yaml");
        this.aboutUsModal = aboutUsModal;
    }

    @Then("I see the about us modal with a correct header appears")
    public void iSeeTheAboutUsModalWithACorrectHeaderAppears() {
        assertTrue(aboutUsModal.isDisplayed(), "The 'About us' modal is not displayed");
        String actualHeader = aboutUsModal.getHeaderText();
        String expectedHeader = data.get("aboutUsModalHeader");
        assertEquals(actualHeader, expectedHeader, "The 'About us' modal has an incorrect header");
    }
}
