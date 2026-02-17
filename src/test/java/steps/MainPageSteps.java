package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.MainPage;

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
}
