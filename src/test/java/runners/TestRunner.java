package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks", "context", "driver", "pages", "utils"},
        tags = "@mainPage", //logInModal, mainPage, cart
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"
        }, monochrome = true //what is this?
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
