Feature: To create leads in sales force application

Scenario Outline: To login and create leads with valid credential

Given Launch browser and load url and maximize the screen
And Enter the username as 'dilip@testleaf.com'
And Enter the password as 'leaf@2024'
When Click on the Login button
And Click on the toggle menu button in the left corner
And Click on View All and select Sales from the App Launcher
And Click on the Opportunity tab
And Click on the New button
And Enter the Opportunity name as <urName>
And Enter Amount as <amount>
And Choose the close date as Today
And Select Stage as Need Analysis
And Click on the Save button
Then Verify the Opportunity Name as <oppName> 

Examples:
|urName|amount|oppName|
|'Salesforce Automation by SaravanaKarthik'|'7500'|'Salesforce Automation by SaravanaKarthik'|
|'Salesforce Automation by Nagaraj'|'6500'|'Salesforce Automation by Nagaraj'|
|'Salesforce Automation by Poovizhi'|'5500'|'Salesforce Automation by Poovizhi'|
|'Salesforce Automation by Jegadish'|'4500'|'Salesforce Automation by Jegadish'|

