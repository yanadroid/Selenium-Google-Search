package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverCreator {

    private static WebDriverCreator instance;
    private List<WebDriver> drivers = new LinkedList<>();

    private WebDriverCreator() { }

    public static void init() {
        if (instance == null) {
            instance = new WebDriverCreator();
        }
    }

    public static WebDriverCreator get() {
        return instance;
    }

    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        drivers.add(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
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
