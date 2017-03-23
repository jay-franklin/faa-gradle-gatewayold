#Author: jay.franklin@csra.com


@all_faa @gateway_group2 @change_non_hobbyist_primary_email  @change_non_hobbyist_primary_email.feature
Feature: Change a non hobbyist user primary email
User Stories [UAS-20][UAS-93][UAS-815][UAS-816][UAS-823][UAS-824][UAS-826][UAS-827][UAS-831][GP-16]
	This feature changes the primary email address of a non hobbyist user

Scenario: Scenario 1 - Change the primary email address of a non hobbyist user -- 17 Steps
Given i have accessed the welcome page
When i click on the Login button
Then i click on the I Agree button
Then log in with random account to change primary email
Then click the welcome dropdown menu
Then i click on the edit Profile button
Then click to edit Primary Email Address
Then complete the change primary email address form
Then i click the logout button