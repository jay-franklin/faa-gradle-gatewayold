#Author: jay.franklin@csra.com
#Feature: add_multiple_nh_uas.feature

@all_faa @add_multiple_nh_uas.feature
Feature: Add a new UAS
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	and adds a new UAS

Scenario: Access the FAA UAS Drone Homepage to add a new UAS
Given i have accessed the welcome page
When i click on the Login button
Then i log on using username: 'myfaadrone@gmail.com'
Then i click on the Add UAS Non-Model option
Then i click to add multiple UAS
Then i select a random UAS Type
Then i enter a nickname
Then i enter a manufacturer
Then i enter a model number
Then i enter a serial number
Then i click the Add button
Then i select a random UAS Type
Then i enter a nickname
Then i enter a manufacturer
Then i enter a model number
Then i enter a serial number
Then i click the Add button
Then i select a random UAS Type
Then i enter a nickname
Then i enter a manufacturer
Then i enter a model number
Then i enter a serial number
Then i click the Add button
Then i select a random UAS Type
Then i enter a nickname
Then i enter a manufacturer
Then i enter a model number
Then i enter a serial number
Then i click the Add button
Then i select a random UAS Type
Then i enter a nickname
Then i enter a manufacturer
Then i enter a model number
Then i enter a serial number
Then i click the Add button
Then i select a random UAS Type
Then i enter a nickname
Then i enter a manufacturer
Then i enter a model number
Then i enter a serial number
Then i click the Add button
Then i select a random UAS Type
Then i enter a nickname
Then i enter a manufacturer
Then i enter a model number
Then i enter a serial number
Then i click the Add button
Then i click on the done button
