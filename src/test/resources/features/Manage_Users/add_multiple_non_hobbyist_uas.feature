#Author: jay.franklin@csra.com
@all_faa @add_multiple_non_hobbyist_uas.feature
Feature: add_multiple_non_hobbyist_uas.feature
  User Stories 
  [ UAS-689 ][ UAS-326 ][ UAS-203 ]
  Complete the Profile Page for Non Model Users
  This feature file opens the web browser and logs into the FAA Drone Welcome Page
  then completes the user profile page

Scenario: Access the FAA UAS Drone Homepage with new account
  Given i have accessed the welcome page
  When i click on the Login button
  Then i log in as 'mynewfaadrone@gmail.com'
  Then i click on the Non-Model option
  Then click the MANAGE sUAS INVENTORY button
  Then Add One New UAS
  Then i click to Add Five New UAS
