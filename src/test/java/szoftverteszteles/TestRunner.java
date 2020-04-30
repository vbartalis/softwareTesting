package szoftverteszteles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "szoftverteszteles.stepdef",
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports" },
        monochrome = true)
/**
*TestRunner
*/
public class TestRunner {
    /**
     *The class starts the cucumber tests
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestRunner.class);  /** Logger */
    public TestRunner(){
        LOGGER.info("TestRunner started");

    }
}
