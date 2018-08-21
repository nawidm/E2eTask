package selenium;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/selenium/myFeature.feature"
		,glue="src/main/java/selenium/StepDefinition.java"
		)



public class CucumberRunner {

}
