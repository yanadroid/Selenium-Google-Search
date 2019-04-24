package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private List<WebDriver> drivers = new LinkedList<WebDriver>();

    @AfterClass
    public void quitDrivers() {
        Iterator<WebDriver> iterator = drivers.iterator();
        while (iterator.hasNext()) {
            WebDriver driver = iterator.next();
            driver.quit();
            iterator.remove();
        }
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
}
