Feature: As a customer who has ordered an item from adidas
		I want to track my order to get the latest information about when my ordered product will be delivered
		
		Scenario: Check that inline error messages are displayed
			Given Mike is on Order Tracker page
			When he enters blank in order field
			Then he should see error message 'Please enter your order number.' under order field
			When he enters invalid email address 'abc.xyz'
			Then he should see error message 'The email address is invalid.' under email field
		
		Scenario Outline: Check that proper notification is displayed when providing an invalid order number
			Given Mike is on Order Tracker page
			When he enters an <invalid_order_number>
			And he enters his <valid_email_address>
			And he clicks view order button
			Then he should see error message about invalid combination of order number and email address
			Examples:
			|	invalid_order_number	|	valid_email_address	|
			|	ABC123XYZ	| Mike@gmail.com	|