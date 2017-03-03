#Author: jay.franklin@csra.com
#Feature: create_non_hobbyist_account1.feature

@all_faa @jay_group @create_new_account  @create_non_hobbyist_alt_email1.feature
Feature: Create non hobbyist account update verify alternate email
This feature file opens the web browser and logs into gmail and deletes all messages in the Inbox

Scenario: Scenario 1 - Create non hobbyist account update - Delete Inbox Messages -- 13 Steps
Given i have accessed the gmail login page
When i log on using newly created email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then i select and delete all messages from the inbox
Then i sign out of gmail