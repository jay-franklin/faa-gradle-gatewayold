#Author: jay.franklin@csra.com

@all_faa @jay_group2 @resend_verification_email @update_nonhobbyist @resend_verification_email1.feature
Feature: resend_verification_email
User Story [UAS-133]
As a user who is unable to locate the account activation email, 
I need a way to have the email re-sent to me so that I can 
activate my account and continue with my registration.

Scenario: Scenario 2 - Access the FAA UAS Drone Homepage to resend verification email -- 15 Steps
Given i have accessed the gmail login page
When i log on using newly created email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then i click on inbox message to confirm account
Then i click on email link to confirm account
Then i click open email that verifies account registration
