package Steps;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "Steps",
        plugin = {
                "pretty",
                "html:test-output",
                "json:target/json_output/cucumber.json",
                "html:target/cucumber-html-report"
        },
        monochrome = true,
        dryRun = false
)


public class TestRunner {
}
