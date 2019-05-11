package definitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.logger.Log;

public abstract class BaseDefinition {

    void openLink(WebDriver driver, String link) {
        Log.info("Open browser: " + link);
        driver.get(link);
    }

    void sendKeys(WebElement element, String key) {
        Log.info("Send keys: " + key);
        element.clear();
        element.sendKeys(key);
        element.sendKeys(Keys.RETURN);
    }
}
