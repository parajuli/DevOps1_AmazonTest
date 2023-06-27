Feature: Search for Sony TV on Amazon Australia website

  Scenario: Filter and sort Sony TV search results
    Given I am on the Amazon Australia website
    When I search for 'Sony tv'
    And I set the brand to Sony
    And I set the resolution filter to 4k
    And I set the model year to 2022
    And I sort results by price high to low
    Then I print the price of the lowest and highest ticketed items
    And I close the browser