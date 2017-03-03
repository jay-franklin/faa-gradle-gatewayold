#Author: jay.franklin@csra.com

@all_faa @jay_group2 @manage_access @update_nonhobbyist

Feature: Access the Manage Access Tool
User Stories [ UAS-20 ][ UAS-93 ][ UAS-815 ][ UAS-816 ][ UAS-823 ][ UAS-824 ][ UAS-826 ][ UAS-827 ][ UAS-831 ][ UAS-980 ]
This feature file logs in as an Admin to access the Manage Access Tool Page

Scenario: Scenario 1 - Gateway App Validate the Login Access Tool -- 12 Steps

Given i have accessed the welcome page
When i click on the Login button
Then log in with random gateway hobbyist account
#Then i log in as admin using 'mynewfaadrone+JayAdmin@gmail.com'
#Then click on the Contact Information option
#Then i click on the Manage Access Tool option
Then i click the logout button    
