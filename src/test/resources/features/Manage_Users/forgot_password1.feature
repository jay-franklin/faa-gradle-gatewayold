
#Author: jay.franklin@csra.com

@all_faa @jay_group2 @forgot_password @update_nonhobbyist @forgot_password1.feature
Feature: resend_verification_email
As a user who is unable to remember their password.
I need a way to have the email re-sent to me so that I can 
activate my account password and continue with my registration.
Scenario: 1 - Forgot Password Test -- 11 Steps
Given i have accessed the welcome page
When i click on the Login button
Then i click on the I Agree button
Then i click the forgot password link
Then i type email address from forgot password page
Then i click the send button
