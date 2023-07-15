package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featureFiles/",
        plugin ="json:target/jsonReports/cucumber-report.json", //this plugin is used to create maven-cucumber-reporting
        glue = {"stepDefinitions"})

public class TestRunner {
}
