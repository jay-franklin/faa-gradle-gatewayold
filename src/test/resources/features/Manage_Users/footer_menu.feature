#Author: jay.franklin@csra.com

@all_faa  @jay_group2 @footer 
Feature: Footer Menu link verification
User Stories [UAS-1][UAS-91][ UAS-2 ][ UAS-315 ][ UAS-128 ][ UAS-149 ][ UAS-335 ]
This feature file verifies all footer menu options are accessed successfully


Scenario: Scenario 1 - Log in as Admin with an existing account -- 28 Steps 
Given i have accessed the welcome page
Then click on the Contact Information option
Then click on Footer Menu Dot
When i click on the Login button
Then i click on the I Agree button
Then log in with random account to update personal and organization info
Then click on Footer Menu Dot
Then click on Footer Menu WebPolicies
Then click on Footer Menu PrivacyPolicy
Then click on Footer Menu Accessibility
Then click on Footer Menu Transportation
Then click on Footer Menu Usa 
Then click on Footer Menu Plainlanguage 
Then click on Footer Menu Regulations 
Then click on Footer Menu Data 
Then click on Footer Menu Faq 
Then click on Footer Menu AllQuestions 
Then click on Footer Menu ContactFaa 
Then click on Footer Menu Oig 
Then click on Footer Menu Foia 	
Then i click the logout button    
