#Author: jay.franklin@csra.com
@all_faa @jay_group @create_new_account
Feature:  Create non hobbyist account update verify alternate email
  User Stories 
  [ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
  Complete the Profile Page for Non Model Users
  This feature file opens the web browser and logs into the FAA Drone Welcome Page
  then completes the user profile page
  Confirm and Verify New Account
Scenario: Scenario 4 - Create non hobbyist account update - Completes New Account Profile -- 51 Steps
Given i have accessed the welcome page
When i click on the Login button
Then i log on using new email account
Then i click on the Non-Model option
Then i complete your profile page
Then i validate the physical and mailing address
Then i click on the Profile Tab
Then i click on the edit Profile button
Then update nh alternate email address to match user account
