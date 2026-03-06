package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks", "context", "driver", "pages", "utils"},
        tags = "@navBar", //logInModal, mainPage, cart
        plugin = {"pretty",
                "html:target/cucumber-navBar.html",
                "json:target/cucumber-navBar.json"
        }, monochrome = true //what is this?
)

public class NavBarRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
