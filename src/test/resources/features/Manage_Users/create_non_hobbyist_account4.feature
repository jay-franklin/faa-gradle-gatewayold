#Author: jay.franklin@csra.com

@all_faa @jay_group @create_non_hobbyist_account 
Feature:  Create new non hobbyist account
User Stories 
[ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
[GP-169]
Complete the Profile Page for Non Model Users
This feature logs into the FAA Drone Welcome Page
then completes a new user profile, adds 5 UASs and completes the payment process

Scenario: Scenario 4 - Create non hobbyist account update - Add 5 UAS for New Account -- 41 Steps
Given i have accessed the welcome page
When i click on the Login button
Then i log on using new email account
Then i click on the Non-Model option
Then complete new non Model profile page
Then acknowledge safety guidance
#Then i validate the physical and mailing address
#Then i click on the Inventory tab
#Then i click to Add Five New UAS
Then i click the logout button
