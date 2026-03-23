package steps;

import pages.BasePage;
import utils.TestData;

import static org.testng.Assert.assertEquals;

public class BaseSteps {

    protected final TestData data;

    //constructor
    public BaseSteps(String filePath) {
        this.data = new TestData(filePath);
    }

    //helper methods
    public void assertPageTitle(BasePage page, String pageName, String expectedTitle) {
        String actualTitle = page.getTitle();
        assertEquals(actualTitle, expectedTitle, "'" + pageName + "' page title is not correct");
    }
}
