#Author: jay.franklin@csra.com
@all_faa @add_one_non_hobbyist_uas @non_hobbyist_profile @add_one_non_hobbyist_uas.feature
Feature: Add one non hobbyist uas to shopping cart
  User Stories 
  [ UAS-689 ][ UAS-326 ][ UAS-203 ][ UAS-781 ]
This feature file opens the web browser and logs in as an existing non hobbyist user
then adds 1 UAS to their shopping cart
Scenario Outline: Access the FAA UAS Drone Homepage with new account -- 66 Steps
Given access the welcome page <number>
Then click on the Non-Model Aircraft Tab
Then i click on the I Agree button
Then log in with random non hobbyist account
Then click the MANAGE sUAS INVENTORY button
Then Add One New UAS
Then click on the CheckOut Button
Then acknowledge safety guidance
Then complete payment for the non hobbyist user
Then i click the logout button
Examples:
| number |
| one |
| two |
| three |

