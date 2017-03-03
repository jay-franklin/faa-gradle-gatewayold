#Author: jay.franklin@csra.com


@all_faa @jay_group2 @update_non_hobby  @update_non_hobby_profile @update_non_hobby_address_add_uas.feature
Feature: Update the Profile for non hobbyist account
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then edits the user profile

Scenario: Scenario 1 - Update the Profile and validate the addresses for an existing non hobbyist -- 47 Steps
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
Then i click to Add Five New UAS
Then i click the logout button
