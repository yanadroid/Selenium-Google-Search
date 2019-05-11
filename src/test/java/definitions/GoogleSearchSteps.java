package definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import helper.ScreenshotUtility;

import static helper.driver.WebDriverCreator.get;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
import static org.testng.Assert.*;


public class GoogleSearchSteps extends BaseDefinition {

    private GoogleSearchPage page;
    private WebDriver driver;

    @Given("Open URL: {string}.")
    public void openLink(String link) {
        driver = get().getDriver();
        get().addDriverCollection(driver);
        page = new GoogleSearchPage(driver);
        openLink(driver, link);
    }

    @Then("Click on first link of result and see that a title on web page is {string}.")
    public void resultTitleFromFirstClickedLink(String key) {
        sendKeys(page.getSearch(), key);
        page.onClick(page.getLink());
        assertNotNull(page.getTitle());
        assertTrue(containsIgnoreCase(page.getTitle(), key));
    }

    @Then("Send {string} and found that this link {string} is available on first {int} pages.")
    public void searchLinkOnPage(String key, String link, int pages) {
        sendKeys(page.getSearch(), key);
        page.searchLinkOnPages(pages, link);
        assertNotNull(page.getLinkElement());
        assertEquals(link, page.getLinkElement().getText());
    }

    @After
    public void afterMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtility.captureScreenshot(driver, scenario.getName());
        }
    }
}
