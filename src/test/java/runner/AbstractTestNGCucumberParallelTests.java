package runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import driver.WebDriverCreator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverCreator.init();
    }

    @AfterClass
    public void quitDrivers() {
        WebDriverCreator.get().quitDrivers();
    }
}
