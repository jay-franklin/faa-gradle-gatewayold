#Author: jay.franklin@csra.com

@all_faa @old_non_hobbyist @1complete_your_nh_profile.feature
Feature: 1complete_your_nh_profile.feature
User Stories 
[ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
[ UAS-17 ][ UAS-18 ][ UAS-19 ][ UAS-20 ][ UAS-22 ][ UAS-24 ][ UAS-57 ][ UAS-93 ][ UAS-108 ][ UAS-111 ]
[ UAS-147 ][ UAS-188 ][ UAS-203 ][ UAS-204 ][ UAS-292 ][ UAS-293 ][ UAS-294 ][ UAS-295 ]
[ UAS-296 ][ UAS-297 ][ UAS-298 ][ UAS-299 ][ UAS-300 ][ UAS-301 ][ UAS-302 ][ UAS-303 ]
[ UAS-304 ][ UAS-305 ][ UAS-308 ][ UAS-309 ][ UAS-311 ][ UAS-313 ][ UAS-315 ][ UAS-322 ]
[ UAS-326 ][ UAS-328 ][ UAS-329 ][ UAS-384 ][ UAS-385 ][ UAS-417 ][ UAS-418 ][ UAS-419 ]
[ UAS-436 ][ UAS-530 ][ UAS-544 ][ UAS-625 ][ UAS-639 ][ UAS-689 ][ UAS-746 ][ UAS-750 ]
[ UAS-779 ][ UAS-781 ][ UAS-846 ]
  Complete the Profile Page for Non Model Users
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then completes the user profile page

Scenario: Access the FAA UAS Drone Homepage with new account
Given i have accessed the welcome page
When i click on the Login button
Then i log on using new email account
Then i click on the Non-Model option
Then i complete your profile page
Then i validate the physical and mailing address
Then i click to add multiple UAS


