#Author: jay.franklin@csra.com
@all_faa @faa_address @faa_mailing_address @validate_existing_nonhobbyist_mailing_address.feature
Feature: validate_existing_nonhobbyist_mailing_address.feature
  User Stories 
  [ UAS-689 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ][ 890 ] 
  Complete the Profile Page for Non Model Users
  This feature file opens the web browser and logs into the FAA Drone Welcome Page
  then completes the user profile page
  Edit United States Address an existing Non Hobbyist Account		
  Login 
  click Non Hobbyist button
  click profile Tab
  click edit button
  verify the is same as checkbox is unchecked
  select Mailing  Address Country of United Stated
  Update Mailing  Address address1
  update Mailing  Address address2
  Update Mailing  Address city
  update Mailing  Address state
  update Mailing  Address zip code
  click save button

  Scenario: --- Step 1 ---- Update the Mailing Address of a user with an existing account
    Given i navigate to the FAA UAS welcome page
    When i click on the Login button
    Then i log in as 'myfaadrone+138@gmail.com'
    Then i click on the Non-Model option
    Then i click on the Profile Tab
    Then i click on the edit Profile button
    Then i update the Mailing Address for an existing account
		Then i validate the physical and mailing address
    Then i click the logout button

   Scenario: --- Step 2 ---- Update the Mailing Address of a user with an existing account
    Given i navigate to the FAA UAS welcome page
    When i click on the Login button
    Then i log in as 'myfaadrone+150@gmail.com'
    Then i click on the Non-Model option
    Then i click on the Profile Tab
    Then i click on the edit Profile button
    Then i update the Mailing Address for an existing account
		Then i validate the physical and mailing address
    Then i click the logout button   
    
    