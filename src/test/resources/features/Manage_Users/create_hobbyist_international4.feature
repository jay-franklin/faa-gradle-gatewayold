#Author: jay.franklin@csra.com

@all_faa  @jay_group3 @create_new_account @create_hobbyist_international1_2_3 @create_hobbyist_international4.feature
Feature: Create new international hobbyist account
User Stories 
[ UAS-1 ][ UAS-2 ][ UAS-3 ][ UAS-4 ][ UAS-8 ][ UAS-93 ][ UAS-9 ][ UAS-11 ][ UAS-15 ][ UAS-16 ]
[ UAS-17 ][ UAS-18 ][ UAS-19 ][ UAS-20 ][ UAS-22 ][ UAS-24 ][ UAS-57 ][ UAS-93 ][ UAS-108 ][ UAS-111 ]
[ UAS-147 ][ UAS-188 ][ UAS-203 ][ UAS-204 ][ UAS-292 ][ UAS-293 ][ UAS-294 ][ UAS-295 ]
[ UAS-296 ][ UAS-297 ][ UAS-298 ][ UAS-299 ][ UAS-300 ][ UAS-301 ][ UAS-302 ][ UAS-303 ]
[ UAS-304 ][ UAS-305 ][ UAS-308 ][ UAS-309 ][ UAS-311 ][ UAS-313 ][ UAS-315 ][ UAS-322 ]
[ UAS-326 ][ UAS-328 ][ UAS-329 ][ UAS-384 ][ UAS-385 ][ UAS-417 ][ UAS-418 ][ UAS-419 ]
[ UAS-436 ][ UAS-530 ][ UAS-544 ][ UAS-625 ][ UAS-639 ][ UAS-689 ][ UAS-746 ][ UAS-750 ]
[ UAS-779 ][ UAS-781 ][ GP-7 ][GP-3][GP-5][GP-169]
  Complete the Profile Page for Model (Hobbyist) Users
	This feature file opens the web browser and logs into the FAA Drone Welcome Page
	then creates a new hobbyist profile 
Scenario: Scenario 4 - Create hobbyist account - Delete all messages in the gmail Inbox -- 13 Steps
Given i have accessed the gmail login page
When i log on using newly created email address
Then i enter my gmail password 'Dummy$11'
Then i click on the gmail inbox
Then i select and delete all messages from the inbox
Then i sign out of gmail
