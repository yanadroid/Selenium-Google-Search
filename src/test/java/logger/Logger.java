package logger;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class Logger {

    public static void log(WebDriver driver, String message) {
        System.out.println(String.format("%10s. %10s: %s", Thread.currentThread().getName(), driver.getClass().getName(), message));
    }
}
