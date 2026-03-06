package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks", "context", "driver", "pages", "utils"},
        tags = "@mainPage", //logInModal, mainPage, cart
        plugin = {"pretty",
                "html:target/cucumber-mainPage.html",
                "json:target/cucumber-mainPage.json"
        }, monochrome = true //what is this?
)

public class MainPageRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
