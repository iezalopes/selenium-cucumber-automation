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
        dryRun = false, // se for "true" da após executar os metodos faltando
        strict = false,
        plugin = {}
)
public class TestRunner {

}
