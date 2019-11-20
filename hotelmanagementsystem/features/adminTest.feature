Feature: Testing the admin features

@Feature1
Scenario: Testing the login functionality
Given the user has loaded the application in the browser
When user click on login link
And the user enters valid email in the emailbox
And the user enters valid password in the password textbox
And the user clicks on the login button
Then the dashboard page must be displayed