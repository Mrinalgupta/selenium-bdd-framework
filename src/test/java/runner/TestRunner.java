
package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "classpath:features",
        glue = {"stepDefinitions","hooks"},
        plugin = {
        "pretty",
        "html:target/cucumber.html"
        }
        )
public class TestRunner extends AbstractTestNGCucumberTests {
}

