package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static driver.WaiterExpectedConditions.waitElement;
import static driver.WebDriverConstants.*;
import static logger.Logger.log;

public class GoogleSearchPage {

    @FindBy(id = "pnnext")
    private WebElement nextPage;
    @FindBy(name = "q")
    private WebElement search;
    @FindBy(xpath = "(//h3)[1]")
    private WebElement link;

    private WebDriver driver;
    private WebElement linkElement;

    public GoogleSearchPage(WebDriver driver, String link) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        openLink(link);
    }

    private void openLink(String link) {
        driver.get(link);
    }

    private void sendKeys(String key) {
        log("Send key: " + key);
        search.clear();
        search.sendKeys(key);
        search.sendKeys(Keys.RETURN);
    }

    public void searchForKeyword(String key) {
        log("Start searchForKeyword() method.");
        sendKeys(key);
        link.click();
    }

    public void searchLinkOnPages(String key, int pages, String link) {
        sendKeys(key);
        for (int i = 0; i < pages; i++) {
            List<WebElement> allLinks = driver.findElements(By.tagName(KEY_TAG_NAME));
            for (WebElement element : allLinks) {
                if (element.getText().equals(link)){
                    linkElement = element;
                    log("Link was found successfully.");
                    return;
                }
            }
            waitElement(driver, nextPage, KEY_TIME_WAIT).click();
        }
    }

    public WebElement getLinkElement() {
        return linkElement;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
