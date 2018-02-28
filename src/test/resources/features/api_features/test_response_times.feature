Feature: API tests for adidas homepage CMS response

Scenario: Check response time for adidas homepage CMS response
Given api request was successful
Then the response time should be less than 1 sec
And all the links should be accessible
And each 'component' object should contain key called 'analytics_name'