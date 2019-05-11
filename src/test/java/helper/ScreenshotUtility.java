package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import helper.logger.Log;

import java.io.File;

public class ScreenshotUtility {

    public static void captureScreenshot(WebDriver driver, String name) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File file = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./Screenshots/" + name + ".png"));
            Log.info("Screenshot was taken.");
        } catch (Exception e) {
            Log.info("Screenshot was not taken.");
        }
    }
}
