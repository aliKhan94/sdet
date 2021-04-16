package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = {"stepDefinitions"},
		plugin = {"pretty", "html:target/cucumber-reports/reports"},
		monochrome = true,
		tags = "@activity1_3"
)

public class ActivityRunner1_3 {

}
