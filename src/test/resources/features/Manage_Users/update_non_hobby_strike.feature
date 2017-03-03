#Author: jay.franklin@csra.com
#Feature: update_non_hobby_us_profile.feature

@all_faa @temp @jay_group2 @faa_strike  @update_nonhobbyist @update_non_hobby_strike.feature
Feature: Strike Verification Test for Existing Non Hobbyist Users
User Stories [ UAS-20 ][ UAS-93 ][UAS-815 ][UAS-816 ][UAS-823 ][UAS-824 ][UAS-826 ][UAS-827 ][UAS-831 ][UAS-929]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then edits the user profile.  Updates the user profile and validates the Strike phase of the address

Scenario: Scenario 1 - Strike Test to Update the Physical and Mailing Address of a user with an existing account -- 48 Steps 
Given i have accessed the welcome page
When i click on the Login button
Then log in with random non hobbyist account
Then validate the random non hobbyist account
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i update my profile for strike three test
Then strike validate the physical and mailing address
Then i click on the Inventory tab
Then i click to Add Five New UAS
Then i click the logout button