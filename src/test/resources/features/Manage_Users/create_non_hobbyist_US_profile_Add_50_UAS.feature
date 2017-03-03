#Author: jay.franklin@csra.com

@all_faa @jay_group @create_non_hobbyist_US_profile_add50 @create_non_hobbyist_US_profile_Add_50_UAS.feature
Feature: Create new non hobbyist account
This feature file opens the web browser and logs into gmail and deletes all messages in the Inbox
User Stories 
[ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
[GP-169]

Scenario Outline:  Scenario 1 - Create non hobbyist profile Add 50 UAS -- 76 Steps
Given access the welcome page <number>
When click on the Non-Model Aircraft Tab
Then i click on the I Agree button
Then i click on Create New Account link
Then enter a new non hobbyist account email address
And i enter a new account password 'Dummy$11'
And i confirm a new account passord 'Dummy$11'
And click the Create Account button
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
Then complete your new non hobbyist profile
Then i validate the physical and mailing address
Then click the MANAGE sUAS INVENTORY button
Then i click to add multiple UAS
Then click the MANAGE sUAS INVENTORY button
Then i click the logout button

Examples:
| number |
| one |

