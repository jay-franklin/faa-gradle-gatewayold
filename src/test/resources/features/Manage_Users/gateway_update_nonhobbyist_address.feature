#Author: jay.franklin@csra.com
@all_faa @gateway_group @gateway_update_nonhobbyist_address @gateway_update_nonhobbyist_address.feature
Feature: Gateway Add one non hobbyist uas to shopping cart
  User Stories 
  [ UAS-689 ][ UAS-326 ][ UAS-203 ][ UAS-781 ]
This feature file opens the web browser and logs in as an existing non hobbyist user
then adds 1 UAS to their shopping cart
Scenario Outline: Edit Non Hobbyist Account -- 66 Steps
Given access the welcome page <number>
When i click on the Login button
Then i click on the I Agree button
Then log in with random account to update personal and organization info
Then click the welcome dropdown menu
Then i click on the edit Profile button
Then click to edit non hobbyist Account Details
Then edit non hobbyist Account Details
Then click to edit non hobbyist Personal Information
Then edit non hobbyist Personal Information
Then i validate the physical and mailing address
Then click on edit non hobbyist Organization Information
Then edit non hobbyist Organization Information
Then i validate the physical and mailing address
Then i click the logout button
Examples:
| number |
| one |
| two |
| three |
| four |
| five |
