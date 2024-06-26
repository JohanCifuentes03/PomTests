package co.com.sofka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/user_register.feature",
        glue = "co.com.sofka.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = { "pretty", "html:C:/Users/Johan Cifuentes/Desktop/JAVA/PomTests/src/test/cucumber-output/cucumber-reports-form.html" },
        monochrome = true
)
public class FormTest {
}
