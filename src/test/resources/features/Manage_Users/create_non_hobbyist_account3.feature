#Author: jay.franklin@csra.com

@all_faa @jay_group @create_non_hobbyist_account 
Feature:  Create new non hobbyist account
User Stories 
[ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
[GP-169]
Complete the Profile Page for Non Model Users
This feature file opens the web browser and logs into the FAA Drone Welcome Page
then completes the user profile page

Scenario: Scenario 3 - Create non hobbyist account update - Confirm and Verify New Account -- 15 Steps
Given i have accessed the gmail login page
When i log on using newly created email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then i click on inbox message to confirm account
Then i click on email link to confirm account
Then i click open email that verifies account registration
    