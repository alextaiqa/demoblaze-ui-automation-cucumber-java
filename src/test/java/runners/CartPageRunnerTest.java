package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks", "context", "driver", "pages", "utils"},
        tags = "@cart",
        plugin = {"pretty",
                "html:target/cucumber-cart.html",
                "json:target/cucumber-cart.json"
        }, monochrome = true
)

public class CartPageRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
