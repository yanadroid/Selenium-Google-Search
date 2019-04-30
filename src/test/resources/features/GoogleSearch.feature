  Feature: Google Search

    Background:
      Given Open URL: "http://www.google.com".

    @SearchTitle
    Scenario: Search title "Automation" when open first link of search results
      Then  Click on first link of result and see that a title on web page is "Automation".

    @SearchLink
    Scenario: Search specific link on first 5 pages of result
      Then Send "Automation" and found that this link "https://www.automationgame.com/" is available on first 5 pages.
