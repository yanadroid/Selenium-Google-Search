package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helper.logger.Log;

import java.util.List;

import static helper.driver.WaiterExpectedConditions.waitElement;

public class GoogleSearchPage extends BasePage {

    @FindBy(id = "pnnext")
    private WebElement nextPage;
    @FindBy(name = "q")
    private WebElement search;
    @FindBy(xpath = "(//h3)[1]")
    private WebElement link;

    private WebElement linkElement;

    private final static String KEY_TAG_NAME = "cite";
    private static final long KEY_ELEMENT_WAIT = 5000;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchLinkOnPages(int pages, String link) {
        for (int i = 0; i < pages; i++) {
            List<WebElement> allLinks = driver.findElements(By.tagName(KEY_TAG_NAME));
            for (WebElement element : allLinks) {
                if (element.getText().equals(link)){
                    linkElement = element;
                    Log.info("Link on pages was found: " + link);
                    return;
                }
            }
            waitElement(driver, nextPage, KEY_ELEMENT_WAIT).click();
        }
    }

    public WebElement getLinkElement() {
        return linkElement;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement getSearch() {
        return search;
    }

    public WebElement getLink() {
        return link;
    }
}
