Feature: Login Functionality for Leaftaps Application

Scenario: Successful login with valid crenditals
Given the user is on the login page
When the user enters username as demosalesmanager
And the user enters password as crmsfa
And the user clicks the login button
Then the user should be redirected to welcome page
And user should view the welcome message

Scenario: Failed Login with invalid crenditals
Given the user in on the login page
When the user enters username as demosalesmanager
And the user enters password as crms
And the user clicks the login button
But the user should not to redirected to welcome page

