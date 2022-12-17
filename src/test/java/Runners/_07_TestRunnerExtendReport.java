package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class _07_TestRunnerExtendReport extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name 2","Omer Boncuk");
        ExtentService.getInstance().setSystemInfo("Application name","Campus");
        ExtentService.getInstance().setSystemInfo("Department","QA");
        ExtentService.getInstance().setSystemInfo("Machine", 	"Windows 11" + "64 Bit");
        ExtentService.getInstance().setSystemInfo("Selenium", "3.7.0");
        ExtentService.getInstance().setSystemInfo("Maven", "3.5.2");
        ExtentService.getInstance().setSystemInfo("Java Version", "1.8.0_151");
    }
}
