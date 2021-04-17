package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/java/FeatureFiles",
    glue = {"TestDefination"},
    tags="@HRMScenario3",
    monochrome = true
)
public class AlchemyHRM3 {

}
