package helper.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebDriverCreator {

    private static WebDriverCreator instance;
    private static List<WebDriver> drivers = new ArrayList<>();
    private static final long KEY_GLOBAL_IMPLICITlY_WAIT = 10000;


    private WebDriverCreator() { }

    public static WebDriverCreator get() {
        if (instance == null) {
            instance = new WebDriverCreator();
        }
        return instance;
    }

    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(KEY_GLOBAL_IMPLICITlY_WAIT, TimeUnit.MILLISECONDS);
        return driver;
    }

    public void addDriverCollection(WebDriver driver) {
        drivers.add(driver);
    }

    public void quitDrivers() {
        Iterator<WebDriver> iterator = drivers.iterator();
        while (iterator.hasNext()) {
            WebDriver driver = iterator.next();
            driver.quit();
            iterator.remove();
        }
    }
}
