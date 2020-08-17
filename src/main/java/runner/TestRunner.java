package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/resources/features",
        glue = "steps",
        //tags = {"@Smoke", "~@RegressionTest"},
        monochrome = true, // habilita cores de execução
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}
