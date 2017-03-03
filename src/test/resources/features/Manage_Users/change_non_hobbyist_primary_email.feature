#Author: jay.franklin@csra.com


@all_faa @change_non_hobbyist_primary_email  @change_non_hobbyist_primary_email.feature
Feature: Change a non hobbyist user primary email
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature changes the primary email address of a non hobbyist user

Scenario: Scenario 1 - Change the primary email address of a non hobbyist user -- 13 Steps
Given i have accessed the welcome page
When i click on the Login button
Then i click on the I Agree button
Then log in with random account to change primary email
Then click the welcome dropdown menu
Then i click on the edit Profile button
Then click to edit Primary Email Address
Then edit non hobbyist Account Details
Then click to edit non hobbyist Personal Information
Then click on the change primary email link
Then complete the change primary email address form
