package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.GoogleSearchPage;

import static driver.WebDriverCreator.get;
import static logger.Logger.log;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
import static org.testng.Assert.*;


public class GoogleSearchSteps {

    private GoogleSearchPage page;

    @Given("Open URL: {string}.")
    public void openLink(String link) {
        log("Open web page.");
        page = new GoogleSearchPage(get().getDriver(), link);
    }

    @Then("Click on first link of result and see that a title on web page is {string}.")
    public void resultTitleFromFirstClickedLink(String key) {
        log("Start resultTitleFromFirstClickedLink() method.");
        page.searchForKeyword(key);
        assertNotNull(page.getTitle());
        assertTrue(containsIgnoreCase(page.getTitle(), key));
    }

    @Then("Send {string} and found that this link {string} is available on first {int} pages.")
    public void searchLinkOnPage(String key, String link, int pages) {
        log("Start searchLinkOnPage() method.");
        page.searchLinkOnPages(key, pages, link);
        assertNotNull(page.getLinkElement());
        assertEquals(link, page.getLinkElement().getText());
    }
}
