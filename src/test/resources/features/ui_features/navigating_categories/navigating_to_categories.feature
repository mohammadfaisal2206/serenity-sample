Feature: Navigate to product categories
	As a customer who is interested in buying a product from adidas,
	I should be able to navigate to the category where I can easily find my product
	
	Scenario Outline: Navigate to different categories 
		Given Mike is on the homepage
		When he hovers on to the '<category>' category
		Then he should see links '<category_links>' under column '<column>'
		Examples:
		|	category	|	category_links	|	column	|
		|	Men	|	New arrivals, Release Dates, This week’s top sellers, Adicolor, Cold Blooded - Football Collection, UltraBOOST, Free personalization, Outlet	|	Featured	|
		|	Women	|	T-Shirts & Tank Tops, Sweatshirts, Sports-Bras, Jerseys, Hoodies & Track tops, Jackets, Tracksuits, Trousers, Tights, Shorts, Dresses, Swimwear, Skirts	|	Clothing	|
