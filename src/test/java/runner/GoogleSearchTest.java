package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/GoogleSearch.feature",
        glue = {""}, plugin = {"json:target/cucumber-report/result.json"})
public class GoogleSearchTest {
}
