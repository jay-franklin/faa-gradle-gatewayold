#Author: jay.franklin@csra.com

@all_faa @jay_group @create_non_hobbyist_account @create_non_hobbyist_account2.feature
Feature: Create new non hobbyist account
User Stories 
[ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
[GP-169]
Complete the Profile Page for Non Model Users
This feature file opens the web browser and logs into the FAA Drone Welcome Page
then completes the user profile page

Scenario: Scenario 2 - Create non hobbyist account update - Create New Account -- 14 Steps
Given i navigate to the FAA UAS welcome page
When i create a new account
Then i enter a new non hobbyist account email address
And i enter a new account password 'Dummy$11'
And i confirm a new account passord 'Dummy$11'
And i i click on Create New Account link
Then i verify the account is created
