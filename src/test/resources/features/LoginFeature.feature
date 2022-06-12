
Feature: Testing SalesForceLogin
Background:
Given User open SalesForce application
  @smoke
  Scenario: Login error message
    
    When user on "Login"
    And User enters value into text box username
    And User clears text box password
    And click on button "Login"
    Then enter password message should be displayed
    
   Scenario: Login to SFDC
    
    When user on "Login"
    And User enters value into text box username
    And User enters value into text box password
    And click on button "Login"
    Then User should be on "Home"
    
   Scenario: Test the remember username check box
   
   	When user on "Login"
   	And User enters value into text box username
    And User enters value into text box password
    And User checks remember me checkbox
    When user on "Home"
    And click on button "Logout"
    Then user on "Login"
    And username should be displayed
    
   Scenario: Test forgot password
   
   	When user on "Login"
    And User enters value into text box username
    And click on forgot password
    When user is on forgot password page
    Then check your email message should be displayed 
	
	Scenario: Test Login Error Message
	
		When user on "Login"
    And User enters wrong value into text box username
    And User enters wrong value into text box password
    And click on button "Login"
    Then error message should be displayed
 # @tag2
 # Scenario Outline: Title of your scenario outline
 #   Given I want to write a step with <name>
 #   When I check for the <value> in step
 #   Then I verify the <status> in step

 #   Examples: 
 #     | name  | value | status  |
 #     | name1 |     5 | success |
 #     | name2 |     7 | Fail    |
