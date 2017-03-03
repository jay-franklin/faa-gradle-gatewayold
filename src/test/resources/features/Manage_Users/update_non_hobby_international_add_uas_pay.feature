#Author: jay.franklin@csra.com
#Feature: update_non_hobby_international_add_uas_pay.feature

@all_faa @jay_group @temp @non_hobbyist @update_nonhobbyist @update_non_hobby_international_add_uas_pay.feature
Feature: Update the International profile for Non Model Users
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then edits the Non Hobbyist International user profile, adds 5 Uas'S and completes payment

Scenario: Scenario 1 - Update Non Hobbyist International profile, add Five UAS and complete payment
#Scenario: Step A1 - accessed the welcome page
Given i have accessed the welcome page

#Scenario: Step A2 - click on the Login button
When i click on the Login button

#Scenario: Step A3 - log in with an random non hobbyistg account
Then log in with random non hobbyist account

Then validate the random non hobbyist account

#Scenario: Step A4 - click on the Non-Model option
Then i click on the Non-Model option

#Scenario: Step A5 - click on the Profile Tab
Then i click on the Profile Tab

#Scenario: Step A6 - click on the edit Profile button
Then i click on the edit Profile button

#Scenario: Step A7 - update the international profile
Then update the international hobbyist profile

#Scenario: Step A8 - validate the physical and mailing address
Then i validate the physical and mailing address

#Scenario: Step A9 - click on the Inventory tab
Then i click on the Inventory tab

#Scenario: Step B1 - click to Add Five New UAS
Then i click to Add Five New UAS

#Scenario: Step B2 - click the logout button
Then i click the logout button
