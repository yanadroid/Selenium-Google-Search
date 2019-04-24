package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;


public class GoogleSearchTest extends BaseTest {

    private final static String GOOGLE_URL = "http://www.google.com";
    private final static String URL_AUTOMATION = "https://www.automationgame.com/";
    private final static String TITLE_AUTOMATION = "Automation";

    @BeforeClass
    public void setUpDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void searchTitleTest() {
        GoogleSearchPage page = new GoogleSearchPage(getDriver());
        page.openLink(GOOGLE_URL).sendKeys(TITLE_AUTOMATION).searchSpecificAutomationTitle();
    }

    @Test
    public void searchAutomationLinkTest() {
        GoogleSearchPage page = new GoogleSearchPage(getDriver());
        page.openLink(GOOGLE_URL).sendKeys(TITLE_AUTOMATION).searchLinkOnPages(URL_AUTOMATION);
    }
}
