package context;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TestContext {
    private ScenarioContext scenarioContext;
    private HashMap<String, Object> values;

    public TestContext(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
        this.values = new HashMap<>();

    }

    public WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    public void setDriver(WebDriver driver){
        //work in progress
    }

    public void set(String key, Object value) {
        values.put(key, value);
    }

    public Object get(String key) {
        return values.get(key);
    }

    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }
}
