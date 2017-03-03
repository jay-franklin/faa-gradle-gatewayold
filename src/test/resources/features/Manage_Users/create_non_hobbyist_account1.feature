#Author: jay.franklin@csra.com

@all_faa @jay_group @create_non_hobbyist_accountxx @create_non_hobbyist_account1.feature
Feature: Create new non hobbyist account
This feature file opens the web browser and logs into gmail and deletes all messages in the Inbox
User Stories 
[ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
[GP-169]
Scenario: Scenario 1 - Create non hobbyist account update - Delete Inbox Messages -- 13 Steps
Given i have accessed the gmail login page
When i log on using newly created email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then i select and delete all messages from the inbox
Then i sign out of gmail
