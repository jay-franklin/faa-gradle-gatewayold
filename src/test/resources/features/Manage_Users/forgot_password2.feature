#Author: jay.franklin@csra.com

@all_faa @jay_group2 @forgot_password @update_nonhobbyist @forgot_password2.feature
Feature: forgot_password
User Story [UAS-133][UAS-661]
As a user who is unable to remember their password.
I need a way to have the email re-sent to me so that I can 
activate my account password and continue with my registration.

Scenario: 2 - Forgot Password Test -- 12 Steps
Given i have accessed the gmail login page
When i log on using newly created email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then i click on inbox message Forgot your password
Then i click email message to reset password
