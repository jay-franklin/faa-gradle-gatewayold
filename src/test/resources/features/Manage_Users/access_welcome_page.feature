#Author: jay.franklin@csra.com
#Feature: access_welcome_page.feature

@all_faa @delete_gmail_messages @access_welcome_page.feature
Feature: Access the Welcome suas homepage
This feature file opens the web browser and logs into the FAA Drone Welcome Page

Scenario: Access the gmail login page
Given i have accessed the gmail login page
When i log on using newly created email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then i select and delete all messages from the inbox
Then i sign out of gmail