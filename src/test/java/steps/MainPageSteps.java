package steps;

import io.cucumber.java.en.*;
import pages.MainPage;
import utils.TestData;

import static org.testng.Assert.*;

public class MainPageSteps {

     private MainPage mainPage;


     public MainPageSteps(MainPage mainPage){
         this.mainPage = mainPage;
     }

    @Given("I open the main page")
    public void iOpenTheMainPage(){
        mainPage.openMainPage();
    }

    @Then("I see a welcome message")
    public void iSeeAWelcomeMessage() {
         mainPage.confirmAWelcomeMessage();
    }

    @Then("I see a correct main page title")
    public void iSeeACorrectMainPageTitle() {
        String actualTitle = mainPage.getMainPageTitle();
        String expectedTitle = TestData.mainPageTitle;
        assertEquals(actualTitle, expectedTitle, "Main page title is not correct");
    }
}
