package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static logger.Logger.log;

public class GoogleSearchPage {

    @FindBy(id = "pnnext")
    private WebElement nextPage;
    @FindBy(name = "q")
    private WebElement search;
    @FindBy(xpath = "//*[text() = 'Automation']")
    private WebElement title;
    @FindBy(xpath = "(//h3)[1]")
    private WebElement link;

    private WebDriver driver;
    private WebElement linkElement;

    public GoogleSearchPage(WebDriver driver, String link, String key) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        openLink(link);
        sendKeys(key);
    }

    private void openLink(String link) {
        driver.get(link);
    }

    private void sendKeys(String key) {
        search.clear();
        search.sendKeys(key);
        search.sendKeys(Keys.RETURN);
    }

    public void searchSpecificAutomationTitle() {
        link.click();
    }

    public void searchLinkOnPages(String link) {
        for (int i = 0; i < 5; i++) {
            List<WebElement> allLinks = driver.findElements(By.tagName("cite"));
            for (WebElement element : allLinks) {
                if (element.getText().equals(link)){
                    log("Link was found successfully.");
                    linkElement = element;
                    return;
                }
            }
            waitElement(nextPage).click();
        }
    }

    public WebElement getLinkElement() {
        return linkElement;
    }

    public WebElement getTitleElement() {
        return title;
    }
    private WebElement waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
