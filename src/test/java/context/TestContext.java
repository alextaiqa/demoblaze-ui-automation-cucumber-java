package context;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private ScenarioContext scenarioContext;

    public TestContext(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    public WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    public void setDriver(WebDriver driver){
        //work in progress
    }

    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }
}
