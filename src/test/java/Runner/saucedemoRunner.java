package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/saucedemo.feature", // Path to your feature files
    glue = {"demo"}, // Package where your step definitions are located
    tags = "@E2ETest" ,// Optional: Only run scenarios with this tag
    plugin = {"pretty", "html:target/cucumberReports/cucumberReport.html"} // Optional: Define plugins
)

public class saucedemoRunner {

}
