Feature: open google and search selenium
@smoke
Scenario: Verify search functionality in google
    Given open google page
    When Enter selenium on search box and click on search
    When Selenium should be found sucessfully
    Then close the browser