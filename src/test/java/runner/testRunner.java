package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue={"steps"},
        plugin = {"pretty",},
        monochrome = true,
        snippets = SnippetType.CAMELCASE
        ,tags = "@ExecuteTest"
)

public class testRunner {

}
