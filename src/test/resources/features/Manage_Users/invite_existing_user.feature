#Author: jay.franklin@csra.com
#Feature: invite_new_user.feature
@all_faa @jay_group2 @temp @invite_existing_user @invite_new_user1.feature
Feature: Attempt to Invite an already existing User
  User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ][ 856 ]
  [GP119]
  This feature attempts to invites an existing User

Scenario: Scenario 1 - Invites an existing User -- 28 Steps
Given i have accessed the welcome page
When i click on the Login button
Then i click on the I Agree button
Then i log in as 'mynewfaadrone+JayAdmin@gmail.com'
Then click on the Non-Model Aircraft Tab
Then click the MANAGE USER ACCOUNTS button
Then click on the Add User Button
Then enter existing Invited User Information
Then verify user already invited message is Displayed
Then click the cancel invite button
Then click on the Add User Button
Then verify user already invited message is Displayed
Then click the cancel invite button
Then i click the logout button
 

