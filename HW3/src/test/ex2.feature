Feature: feature file for exercise 2

  Background:
    Given I open the page
    And I log as "Roman" - "Jdi1234"
    Then Username is "ROMAN IOVLEV"
    And Browser title is "Home Page"

  Scenario: Assert the top "Service" subcategory
    Then Drop down options of top Service have proper values

  Scenario: Assert the left "Service" subcategory
    Then Drop down options of left Service have proper values
    
  Scenario: Assert elements
    Given Open Different Elements Page
    Then There are 4 checkboxes
    Then There are 4 radios
    Then There are 1 dropdown
    Then There are 2 buttons  
    
  Scenario: Assert Right and Left Section
    Then Right Section displayed
    And Left Section displayed
    
  Scenario: Select checkboxes
    Given Checkboxes Water are selected
    Then Display the information that Water is selected on the log
    Given Checkboxes Wind are selected
    Then Display the information that Wind is selected on the log
    
  Scenario: Select radio
    Given Radio Selen is selected
    And Status of radios in Log row is displayed and corresponding
    
  Scenario: Select in dropdown
    Given Yellow in dropdown is selected
    And Status of dropdown in Log row is displayed and corresponding
    
  Scenario: Select checkbox again
    Given Checkboxes Water are selected again
    Then Display the information that Water is selected on the log again
    Given Checkboxes Wind are selected again
    Then Display the information that Wind is selected on the log again
    

    
  