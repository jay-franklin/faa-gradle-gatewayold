#Author: jay.franklin@csra.com
#Feature: access_welcome_page.feature

@all_faa @old_non_hobbyist @2complete_your_nh_profile.feature
Feature: Access the Gmail Inbox
This feature file opens the web browser and logs into gmail and deletes all messages in the Inbox

Scenario: Access the gmail login page
Given i have accessed the gmail login page
When i log on using newly created email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then i click on inbox message to confirm account
Then i click on email link to confirm account
Then i click open email that verifies account registration
