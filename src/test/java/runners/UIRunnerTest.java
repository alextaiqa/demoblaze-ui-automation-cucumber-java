package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "steps", "context"},
        tags = "@ui and not @bug",
        plugin = {"pretty",
                "html:target/cucumber-ui.html",
                "json:target/cucumber-ui.json"
        }, monochrome = true //provides cleaner logs
)

public class UIRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
