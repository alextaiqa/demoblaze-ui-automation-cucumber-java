package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/components",
        glue = {"hooks", "steps", "context"},
        tags = "@navBar and not @bug",
        plugin = {"pretty",
                "html:target/cucumber-navBar.html",
                "json:target/cucumber-navBar.json"
        }, monochrome = true
)

public class NavBarRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
