package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/featureFiles/placeValidations.feature",
        glue = {"stepDefinitions"})

public class TestRunner {
}
