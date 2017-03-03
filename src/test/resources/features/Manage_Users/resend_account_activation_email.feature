#Author: jay.franklin@csra.com

@resend_account_activation_email @resend_account_activation_email.feature 
Feature: Resend Account Activation Email
User Story [UAS-133]
As a user who is unable to locate the account activation email, 
I need a way to have the email re-sent to me so that I can 
activate my account and continue with my registration.

Scenario: Scenario 1 - Resend verification email

#Scenario: Step A1 - accessed the welcome page
Given i have accessed the welcome page

#Scenario: Step A2 - click on the login page
When i click on the Login button

#Scenario: Step A3 - click on the resend verification email link
Then i click on the resend verification email link

#Scenario: Step A4 - enter email address
Then i type email address to receive verification

#Scenario: Step A5 - click the send button
Then i click the send button

#Scenario: Step 2 - Confirm and Verify Email Verification is complete

#Scenario: Step B1 - access the Gmail login page
Given i have accessed the gmail login page

#Scenario: Step B2 - log on using newly created email address
When i log on using newly created email address

#Scenario: Step B3 - enter my gmail password
Then i enter my gmail password 'Dummy$11'

#Scenario: Step B4 - access the Gmail Inbox
Then i click on the gmail inbox

#Scenario: Step B5 - Open the confirm account email message
Then i click on inbox message to confirm account

#Scenario: Step B6 - confirm account email message
Then i click on email link to confirm account

#Scenario: Step B7 - verify the account registration
Then i click open email that verifies account registration
