#Author: jay.franklin@csra.com

@all_faa @jay_group2 @login

Feature: Access the Manage Access Tool
User Stories [ UAS-20 ][ UAS-93 ][ UAS-815 ][ UAS-816 ][ UAS-823 ][ UAS-824 ][ UAS-826 ][ UAS-827 ][ UAS-831 ][ UAS-980 ]
This feature file logs in as an Admin to access the Manage Access Tool Page

Scenario: Gateway App Validate the Login Access Tool -- 12 Steps

Given i have accessed the welcome page
When click on the Non-Model Aircraft Tab
When i click on the Login button
Then i click on the I Agree button
Then log in with random gateway non hobbyist account
Then i click the logout button    
