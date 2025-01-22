package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/cermati/cucumber-report.json",  "html:target/results/cermati/index.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@cermati"

)

public class CermatiTestRunner extends BaseTestRunner
{

}
