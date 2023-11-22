package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/video_functionality.feature", // Path to your feature files
    glue = {"stepdefinitions"}, // Package where your step definitions are located
    //tags = "@video" // Optional: Only run scenarios with this tag
    monochrome = true,
   plugin = {"pretty", "html:target/cucumber-reports","junit:target/report.xml"} // Optional: Define plugins
)

public class VideofunctionalityRunner {

}
