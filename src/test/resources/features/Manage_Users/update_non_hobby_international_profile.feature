#Author: jay.franklin@csra.com
#Feature: update_non_hobby_international_profile.feature

@all_faa @jay_group2 @update_gateway_international @update_nonhobbyist @update_non_hobby_international_profile.feature
Feature: Update International Profile for a non hobbyist user
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then update the Non Hobbyist International user profile

Scenario Outline: - Update Non Hobbyist International profile -- 48 Steps
Given access the welcome page <number>
When i click on the Login button
Then i click on the I Agree button
Then log in with random account to update personal and organization info
Then click the welcome dropdown menu
Then i click on the edit Profile button
Then click to edit non hobbyist Account Details
Then edit non hobbyist Account Details
Then click to edit non hobbyist Personal Information
Then update the international address in the personal information section
Then i validate the physical and mailing address
Then click on edit non hobbyist Organization Information
Then update the international address in the organization information section
Then i validate the physical and mailing address
Then i click the logout button
Examples:
| number |
| one |
| two |


