#Author: jay.franklin@csra.com


@all_faa @jay_group @non_hobby_add50   @update_non_hobby_address_add_uas.feature
Feature: Update Non Hobbyist Profile add 50 UAS
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then edits the user profile

Scenario: Scenario 1 - Update the Profile, Add 50 UAS, complete payment -- 47 Steps 
Given i have accessed the welcome page
When i click on the Login button
Then log in with random non hobbyist account
Then validate the random non hobbyist account
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i complete your profile page
Then i validate the physical and mailing address
Then i click on the Inventory tab
Then i click to add multiple UAS
Then i click the logout button
