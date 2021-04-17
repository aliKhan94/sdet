package cucumberTest;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/java/FeatureFiles",
    glue = {"TestDefination"},
    tags="@Scenario1",
    plugin = {"pretty"},
    monochrome = true
)
public class AlchemyJob1 {

}
