#Author: jay.franklin@csra.com
#Feature: update_non_hobby_us_name.feature

@all_faa @non_hobby_name @update_non_hobby_us_name @update_non_hobby_us_name.feature
Feature: Complete the Profile Page for Non Model Users
User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ]
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	update the hobbyist name, but do not change the existing address

Scenario: --- Step 1 ---- Update the hobbyist name.  Leave the address.
Given i have accessed the welcome page
When i click on the Login button
Then i log in as 'myfaadrone+nh1@gmail.com'
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i add profile for non hobbyist alternate email address to 'myfaadrone+nh1@gmail.com'
Then i validate the physical and mailing address
Then i click on the Inventory tab
Then i click to Add Five New UAS
Then i click the logout button

Scenario: --- Step 2 ---- Update the Physical and Mailing Address of a user with an existing account
Given i have accessed the welcome page
When i click on the Login button
Then i log in as 'myfaadrone+nh2@gmail.com'
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i add profile for non hobbyist alternate email address to 'myfaadrone+nh2@gmail.com'
Then i validate the physical and mailing address
Then i click on the Inventory tab
Then i click to Add Five New UAS
Then i click the logout button

Scenario: --- Step 3 ---- Update the Physical and Mailing Address of a user with an existing account
Given i have accessed the welcome page
When i click on the Login button
Then i log in as 'myfaadrone+nh105@gmail.com'
Then i click on the Non-Model option
Then i click on the Profile Tab
Then i click on the edit Profile button
Then i add profile for non hobbyist alternate email address to 'myfaadrone+nh105@gmail.com'
Then i validate the physical and mailing address
Then i click on the Inventory tab
Then i click to Add Five New UAS
Then i click the logout button
