#Author: jay.franklin@csra.com
#Feature: create_and_verify_new_profile.feature

@all_faa @faa_address @create_and_verify_new_profile.feature
Feature: Complete the Profile Page for Non Model Users
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then edits the user profile

Scenario: Access the FAA UAS Drone Homepage to complete a new user profile
Given i have accessed the welcome page
When i click on the Login button
Then i log in as 'myfaadrone+479@gmail.com'
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i complete your profile page
Then i validate the physical and mailing address
Then i click the logout button

Scenario: Access the FAA UAS Drone Homepage to complete a new user profile
Given i have accessed the welcome page
When i click on the Login button
Then i log in as 'myfaadrone+42@gmail.com'
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i complete your profile page
Then i validate the physical and mailing address
Then i click the logout button

Scenario: Access the FAA UAS Drone Homepage to complete a new user profile
Given i have accessed the welcome page
When i click on the Login button
Then i log in as 'myfaadrone+150@gmail.com'
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i complete your profile page
Then i validate the physical and mailing address
Then i click the logout button

Scenario: Access the FAA UAS Drone Homepage to complete a new user profile
Given i have accessed the welcome page
When i click on the Login button
Then i log in as 'myfaadrone+140@gmail.com'
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i complete your profile page
Then i validate the physical and mailing address
Then i click the logout button


Scenario: Access the FAA UAS Drone Homepage to complete a new user profile
Given i have accessed the welcome page
When i click on the Login button
Then i log in as 'myfaadrone+138@gmail.com'
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i complete your profile page
Then i validate the physical and mailing address
Then i click the logout button

