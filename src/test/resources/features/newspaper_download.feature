Feature: Verify the Newspaper edition is downloadable

Scenario: Verify edition download with valid credentials
    Given I am on the MailPlus website
    When I scroll down to the Recent issues and tap on showall
    And I tap to download the June twentyseven edition
    And I sign in with valid credentials "<Username>" and "<Password>"
    Then I wait for the edition to be downloaded

    
    
    Examples:
      | Username                  | Password      |
      | twilightsp2708@gmail.com  | National123!  |