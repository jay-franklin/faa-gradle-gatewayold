#Author: jay.franklin@csra.com
#Feature: invite_new_user.feature
@all_faa @gateway_group @temp @invite_new_user @invite_new_user2.feature
Feature: Invite a New User
  User Stories [ UAS-20 ][ UAS-93 ][ 815 ][ 816 ][ 823 ][ 824 ][ 826 ][ 827 ][ 831 ][ 856 ]
  This feature Invites a New Uer

Scenario: Scenario 2 - Invites a New User -- 10 Steps
Given i have accessed the gmail login page
When i log on to gmail as mynewfaadrone@gmail.com email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then click to Accept Your Invitation
