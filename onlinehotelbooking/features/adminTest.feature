Feature: Testing the admin related features

Background:
Given the admin has loaded the application in the browser
When admin click on login link
And the admin enters valid email in the emailbox
And the admin enters valid password in the password textbox
And the admin clicks on the login button
And the dashboard page must be displayed

@Function1
Scenario: Verifying delete operation on hotel
And click on HOTELLIST link
And click on the DELETE button
Then selected hotel details must be deleted

@Function2
Scenario: Verifying add operation on hotel
And click on the HOTELLIST link
And click on the ADD HOTEL button
And enter hotel name in textbox
And enter location in textbox
And enter image url in textbox
And enter mobile number in textbox
And click on submit button
And close the ADD HOTEL pop up
Then entered hotel details must be added

@Function3
Scenario: Verifying delete operation on room
And click on the ROOMLIST link
And click on DELETE button
Then selected room must be deleted 

@Function4
Scenario: Verifying add operation of room
And click on ADDROOM link
And enter valid hotel id in textbox
And enter valid hotel name in textbox
And enter valid room id in textbox
And select room type
And select room capacity
And select room status
And enter valid room rent textbox
And enter valid image url in  textbox
And click on the submit button
Then entered room details must displayed in roomlist
