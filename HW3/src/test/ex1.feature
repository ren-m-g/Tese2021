
Feature: feature file for exercise 1

  Background:
    Given I open the page
    And I log as "Roman" - "Jdi1234"
    Then Username is "ROMAN IOVLEV"
    And Browser title is "Home Page"

  Scenario: Assert header sections
    Then 4 items of header section have proper texts
    
  Scenario: Assert images
    Then Images are displayed
    
  Scenario: Assert texts below images
    Then There are "4" corresponding texts

  Scenario: Assert main header
    Then First paragraph of main header has proper text
    Then Second paragraph of main header has proper text
    
  Scenario: Assert iframe 
    Then iframe in the center of page
    When Switch to the iframe
    Then Check EPAM logo
    And Switch to home page
    
  Scenario: Assert sub header
    Then Text is "JDI GITHUB" 
    
  Scenario: Assert "JDI GITHUB" block
    Then JDI GITHUB is a Link
    
  Scenario: Assert Left Section
    Then Left Section exists

  Scenario: Assert Footer
    Then Footer exists


    