#Author: jay.franklin@csra.com
#Feature: update_hobby_profile_address.feature

@all_faa @temp @jay_group3  @update_hobby_international @update_hobby_profile_address.feature
Feature: update existing hobbyist international profile
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
[GP-3][GP-5][GP-11][GP-12]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then sends certificate to primary and alternate email addreses
	then cancels the registration certificate

Scenario: Scenario - Gateway update hobbyist international profile-- 45 Steps
Given i have accessed the welcome page
When i click on the Login button
Then log in with gateway hobbyist account to cancel registration
Then validate the random hobbyist account
Then click the welcome dropdown menu
Then i click on the edit Profile button
Then update the international hobbyist profile
Then email the receipt to primary email address
Then email the receipt to alternate email address
Then i cancel certificate if hobbyist already has one
Then renew certificate
Then i click the logout button
