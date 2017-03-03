#Author: jay.franklin@csra.com


@all_faa @jay_group2  @update_non_hobby_expired @verify_non_hobby_expired_status1.feature
Feature: validate expired and invite status for existing account
User Stories [UAS-1048][UAS-1047][UAS-1042][UAS-1041][UAS-1005][UAS-1000][UAS-999][UAS-1095][UAS-1015][UAS-1005]
[UAS-1004][UAS-1000][UAS-998]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then edits the user profile

Scenario: Scenario 1 - Validate expired and invited status for existing account -- 21 Steps
Given i have accessed the welcome page
When i click on the Login button
Then login as active user in org with expired users
Then validate the random non hobbyist account
Then i click on the Non-Model option
Then click on the Users Tab
Then filter by 'Invited' Users
Then click on the edit button
Then click on expired user details button
Then click on Resend Invitation

Scenario: Scenario 2 - Validate expired and invited status for existing account -- 10 Steps
Given i have accessed the gmail login page
When i log on to gmail as mynewfaadrone@gmail.com email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then click to Accept Your Invitation

Scenario: Scenario 3 - Validate expired and invited status for existing account -- 17 Steps
Given i have accessed the welcome page
When i click on the Login button
Then login as active user in org with expired users
Then validate the random non hobbyist account
Then i click on the Non-Model option
Then click on the Users Tab
Then filter by 'Invited' Users
Then click on expired user details button

Scenario: Scenario 4 - Validate expired and invited status --Invites a New User -- 15 Steps
Given i have accessed the welcome page
When i click on the Login button
Then login as active user in org with expired users
Then i click on the Non-Model option
Then click on the Users Tab
Then click on the Add User Option
Then enter new Invited User Information

