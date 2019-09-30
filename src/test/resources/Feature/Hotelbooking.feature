@hotelbooking
Feature: Title of your feature
  I want to use this template for my feature file
  
  Background:
  	Given I am on the hotel booking application

  @add
  Scenario: As a user I want to add the record into the hotel booking application
  	When I enter "sample_firstname" into Firstname
  	And I enter "sample_lastname" into Surname
  	And I enter "200" into Price
  	And I choose "true" into Deposit
  	And I select "2019-11-11" into Check-in
  	And I select "2020-10-10" into Check-out
  	And I click on Save
  	Then I should see the record added to the table
  	
    
  @delete
  Scenario: As a user I want to delete records from the hotel booking application
  	When I click on first delete button
  	Then I should see record deleted from the table
  	
    