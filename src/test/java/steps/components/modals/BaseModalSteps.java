package steps.components.modals;

import io.cucumber.java.en.Then;
import utils.TestData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseModalSteps {

    protected final TestData data;

    public BaseModalSteps(String filePath) {
        this.data = new TestData(filePath);
    }

    @Then("I see the about us modal with a correct header appears")
    public void iSeeTheAboutUsModalWithACorrectHeaderAppears() {
        assertTrue(aboutUsModal.isDisplayed(), "The 'About us' modal is not displayed");
        String actualHeader = aboutUsModal.getHeaderText();
        String expectedHeader = data.get("aboutUsModalHeader");
        assertEquals(actualHeader, expectedHeader, "The 'About us' modal has an incorrect header");
    }
}
