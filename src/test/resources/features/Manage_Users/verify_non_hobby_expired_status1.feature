#Author: jay.franklin@csra.com


@all_faa @jay_group2  @update_non_hobby_expiredxxx @verify_non_hobby_expired_status1.feature
Feature: validate expired and invite status for existing account
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then edits the user profile

Scenario: Scenario 1 - Validate expired and invited status for existing account -- 47 Steps
Given i have accessed the welcome page
When i click on the Login button
#Then log in with random non hobbyist account
Then login as 'mynewfaadrone+JayAdmin@gmail.com'
Then validate the random non hobbyist account
Then i click on the Non-Model option
Then click on the Users Tab
Then filter by 'Invited' Users
Then click on expired user details button
Then click on Resend Invitation


