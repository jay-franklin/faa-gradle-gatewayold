#Author: jay.franklin@csra.com

@all_faa @non_hobby_alt_email @jay_group @update_nonhobbyist  @update_non_hobby_us_alternate_email.feature
Feature: Validate the alternate email address
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	update the hobbyist name, but do not change the existing address

Scenario: Scenario 1 - Update the non hobbyist alternate Email Address -- 47 Steps
Given i have accessed the welcome page
When i click on the Login button
Then log in with existing random account
Then validate the random non hobbyist account
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i add profile for non hobbyist alternate email address to 'mynewfaadrone+nh101@gmail.com'
Then i validate the physical and mailing address
Then i click on the Inventory tab
Then i click to Add Five New UAS
Then i click the logout button
