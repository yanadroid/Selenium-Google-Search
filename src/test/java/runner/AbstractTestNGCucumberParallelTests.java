package runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Listeners;
import helper.AssertionsMessages;
import helper.driver.WebDriverCreator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import helper.logger.Log;

@Listeners(AssertionsMessages.class)
public class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass
    public void setUpDriver() {
        Log.startLog("Set up driver.");
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass(alwaysRun = true)
    public void quitDrivers() {
        Log.endLog("Quit drivers.");
        WebDriverCreator.get().quitDrivers();
    }
}
