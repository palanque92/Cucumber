package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/StepDefinitions/_01_LoginSteps.java",
                "src/test/java/StepDefinitions/_02_CountrySteps.java"
        },
        glue = {"StepDefinitions"},
        dryRun = true // true oldugunda testi calistirmaz sadece features
                      // ait steplerin varligini kontrol eder.
                      // false oldugunda ise testi calistirir.
)

public class _02_TestRunnerBelirliFeatures extends AbstractTestNGCucumberTests {

}
