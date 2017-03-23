#Author: jay.franklin@csra.com

@all_faa @gateway_group @create_non_hobbyist_US_profile_add10 @create_non_hobbyist_US_profile_Add_50_UAS.feature
Feature: Create new non hobbyist account Add 10 UAS Do Not Pay
This feature creates a new Non Hobbyist account, adds 10 UAS.  Do not pay
[ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
[GP-169]

Scenario Outline:  Scenario 1 - Create non hobbyist profile Add 10 UAS -- 80 Steps
Given access the welcome page <number>
When click on the Non-Model Aircraft Tab
Then i click the Register Non Model Button
Then i click on the I Agree button
Then i click on Create New Account link
Then enter a new non hobbyist account email address
And i enter a new account password 'Dummy$11'
And i confirm a new account passord 'Dummy$11'
And click on Create Account Button
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
Then i click on the Login button
Then i click on the I Agree button
Then i log on using new email account
Then complete your new non hobbyist profile
Then i validate the physical and mailing address
Then click the MANAGE sUAS INVENTORY button
#Then i click to add multiple UAS
Then i click to Add Ten New UAS Do Not Pay
Then click the MANAGE sUAS INVENTORY button
Then i click the logout button

Examples:
| number |
| one |

