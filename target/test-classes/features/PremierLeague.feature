Feature: Premier League Table Information

  Scenario: Get the Position and Points for a given team from the Premier League table
    Given I am on the Daily Mail website
    When I click on the Sport menu
    And I scroll down to the Premier League table
    And I click on View all tables
    When I retrieve the Pos, PTS for the following teams
    | Team Name     |
    | Bournemouth   |
    | Arsenal       |
    | Aston Villa   |
    | Brentford     |
    | Burnley       |
    
