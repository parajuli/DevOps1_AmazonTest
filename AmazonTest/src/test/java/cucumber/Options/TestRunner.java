package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/amazon_search.feature",
		glue= {"stepDefinitions"},
		plugin = { "pretty" },
		monochrome = true
		)

public class TestRunner {

}
