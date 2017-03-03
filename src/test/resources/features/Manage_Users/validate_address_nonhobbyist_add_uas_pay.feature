#Author: jay.franklin@csra.com
#Feature: validate_address_nonhobbyist_add_uas_pay.feature

@all_faa @jay_group @faa_address @temp @address_uas_pay @validate_address_nonhobbyist_add_uas_pay.feature
Feature: Update the Profile for Non Hobbyist Users
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then edits the user profile.  Add multiple UASs and pay for them.

Scenario: Scenario 1 - Update the Physical and Mailing Address of a non hobbyist user -- 46 Steps
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
