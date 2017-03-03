#Author: jay.franklin@csra.com
@all_faa  @new_non_hobbyist.feature
Feature: new_non_hobbyist.feature
  User Stories 
  [ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
  Complete the Profile Page for Non Model Users
  This feature file opens the web browser and logs into the FAA Drone Welcome Page
  then completes the user profile page

  Scenario: Create a new account from the FAA UAS Drone Homepage
    Given i navigate to the FAA UAS welcome page
    When i create a new account
    Then i enter a new non hobbyist account email address
    And i enter a new account password 'Dummy$11'
    And i confirm a new account passord 'Dummy$11'
    And i click the create account button
    Then i verify the account is created

  Scenario: Access the gmail login page
    Given i have accessed the gmail login page
    When i log on using newly created email address
    Then i enter my gmail password 'Dummy$11'
    Then i click on the gmail inbox
    Then i click on inbox message to confirm account
    Then i click on email link to confirm account
    Then i click open email that verifies account registration
    Then i click on the gmail inbox
		Then i select and delete all messages from the inbox
		Then i sign out of gmail
  
  Scenario: Access the FAA UAS Drone Homepage with new account
    Given i have accessed the welcome page
    When i click on the Login button
    Then i log on using new email account
    Then i click on the Non-Model option
    Then i complete your profile page
    Then i validate the physical and mailing address
    Then i click to add multiple UAS
