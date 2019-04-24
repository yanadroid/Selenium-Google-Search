package pages;

import logger.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static logger.Logger.*;

public class GoogleSearchPage {

    @FindBy(id = "pnnext")
    private WebElement nextPage;
    @FindBy(name = "q")
    private WebElement search;
    @FindBy(linkText = "testautomationday.com")
    private WebElement automationLink;
    @FindBy(xpath = "//*[contains(text(), 'Automation')]")
    private WebElement title;
    @FindBy(className = "sA5rQ")
    private WebElement firstLink;

    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public GoogleSearchPage openLink(String link) {
        driver.get(link);
        log(driver, "Open URL: " + link);
        return this;
    }

    public GoogleSearchPage sendKeys(String key) {
        search.sendKeys(key);
        search.sendKeys(Keys.RETURN);
        log(driver, "Send Key: " + key);
        return this;
    }

    public void searchSpecificAutomationTitle() {
        log(driver, "Started method searchSpecificAutomationTitle()");
        firstLink.click();
        title.isDisplayed();
    }

    public void searchLinkOnPages(String link) {
        for (int i = 0; i < 5; i++) {
            if (driver.getPageSource().contains(link)) {
                log(driver, "Link was found succesfully");
                return;
            } else {
                waitElement(nextPage).click();
            }
        }
    }

    private WebElement waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
