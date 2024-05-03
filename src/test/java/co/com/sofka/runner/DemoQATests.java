package co.com.sofka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.com.sofka.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = { "pretty", "html:C:/Users/Johan Cifuentes/Desktop/JAVA/TestAutomationReports/cucumber-output/cucumber-reports.html" },
        monochrome = true
)
public class DemoQATests {
}
