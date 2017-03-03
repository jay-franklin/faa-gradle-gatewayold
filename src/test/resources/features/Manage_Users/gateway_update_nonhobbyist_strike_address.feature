#Author: jay.franklin@csra.com
@all_faa @add_one_non_hobbyist_uas @gateway_update_nonhobbyist_strike_address @gateway_update_nonhobbyist_address.feature
Feature: Update non hobbyist strike addess 
  User Stories 
  [ UAS-689 ][ UAS-326 ][ UAS-203 ][ UAS-781 ]
This feature file opens the web browser and logs in as an existing non hobbyist user
updates the profile with Strike Address validation
Scenario Outline: Update Non Hobbyist profile strike address validation -- 69 Steps
Given access the welcome page <number>
When i click on the Login button
Then i click on the I Agree button
Then log in with random account to update personal and organization info
Then click the welcome dropdown menu
Then i click on the edit Profile button
Then click to edit non hobbyist Account Details
Then edit non hobbyist Account Details
Then click to edit non hobbyist Personal Information
Then update personal information for strike test
Then strike validate the physical and mailing address
Then click on edit non hobbyist Organization Information
Then update organization information for strike test
Then strike validate the physical and mailing address
Then i click the logout button
Examples:
| number |
| one |
#| two |
#| three |

