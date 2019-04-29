package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GoogleSearchPage;

import static driver.WebDriverCreator.get;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class GoogleSearchSteps {

    private GoogleSearchPage page;

    @Given("Open URL: {string}")
    public void openLink(String link) {
        page = new GoogleSearchPage(get().getDriver(), link);
    }

    @When("We send a word {string} to Google Search and click Enter.")
    public void sendKeyToGoogleSearch(String key) {
        page.sendKeys(key);
    }

    @Then("We click on first link of result and see that a title on web page is Automation.")
    public void resultTitleFromFirstClickedLink() {
        page.searchSpecificAutomationTitle();
        assertTrue(page.getTitleElement().isDisplayed());
    }

    @Then("We found that this link {string} is available on Google page result.")
    public void foundedLinkOnPage(String link) {
        page.searchLinkOnPages(link);
        assertEquals(link, page.getLinkElement().getText());
    }
}
