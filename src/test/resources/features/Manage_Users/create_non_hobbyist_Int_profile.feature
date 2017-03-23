#Author: jay.franklin@csra.com

@all_faa @jay_group @create_non_hobbyist_Int_profile @create_non_hobbyist_Int_profile.feature
Feature: Create new non hobbyist international profile
This feature file opens the web browser and logs into gmail and deletes all messages in the Inbox
User Stories 
[ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
[GP-169]

Scenario Outline:  Scenario 1 - Create non hobbyist profile with international address -- 225 Steps
Given access the welcome page <number>
When click on the Non-Model Aircraft Tab
Then i click on the I Agree button
Then i click on Create New Account link
Then enter a new non hobbyist account email address
And i enter a new account password 'Dummy$11'
And i confirm a new account passord 'Dummy$11'
And i i click on Create New Account link
Then i verify the account is created

Given i have accessed the gmail login page
When i log on using newly created email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then i click on inbox message to confirm account
Then i click on email link to confirm account
Then i click open email that verifies account registration

Given i have accessed the welcome page
Then click on the Non-Model Aircraft Tab
Then i click on the I Agree button
Then i log on using new email account
Then complete non hobbyist international profile
Then i validate the physical and mailing address
Then click the MANAGE sUAS INVENTORY button
Then Add One New UAS
Then click on the CheckOut Button
Then acknowledge safety guidance
Then complete payment for the non hobbyist user
##Then i click on the Inventory tab
##Then i click to Add Five New UAS
Then i click the logout button


Examples:
| number |
| one |
#| two |
#| three |


