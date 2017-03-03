
#Author: jay.franklin@csra.com

@all_faa @jay_group2 @resend_verification_email @update_nonhobbyist @resend_verification_email1.feature
Feature: resend_verification_email
User Story [UAS-133]
As a user who is unable to locate the account activation email, 
I need a way to have the email re-sent to me so that I can 
activate my account and continue with my registration.

Scenario: Scenario 1 - Access the FAA UAS Drone Homepage to resend verification email -- 11 Steps
Given i have accessed the welcome page
When i click on the Login button
Then i click on the resend verification email link
Then i type email address to receive verification
Then i click the send button
