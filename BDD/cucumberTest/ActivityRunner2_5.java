package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = {"stepDefinitions"},
		tags = "@activity2_5",
		monochrome = true,
		plugin = {"pretty"}
		
)
public class ActivityRunner2_5 {

}
