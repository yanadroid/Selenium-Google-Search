  Feature: Google Search

    Background:
      Given Open URL: "http://www.google.com" and send "Automation"

    @SearchAutomationTitle
    Scenario: Search title "Automation" when open first link of search results
      Then  We click on first link of result and see that a title on web page is Automation.

    @SearchLink
    Scenario: Search specific link on first 5 pages of result
      Then We found that this link "https://www.automationgame.com/" is available on Google page result.
