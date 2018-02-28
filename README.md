# Serenity-sample case study
	Sample Case study for adidas

### Technical stack:

		Framework used : Serenity BDD using screenplay pattern
		Programming Language : Java
		Build Management toold: Maven
		BDD Framework : Cucumber
		Rest API Testing library : Rest Assured
		
### Steps to run tests:

	1. Download the source code into your local folder and extract the contents
	2. There are 3 *.bat files for running tests in different browsers:
		a. Run the "crossBrowserTests.bat" file to run tests in Firefox and Edge
		b. Run the "firefoxTests.bat" file to run tests in Firefox
		a. Run the "edgeTests.bat" file to run tests in Edge
	3. Once tests are completed, the report will be generated. Open the file "\target\site\serenity\index.html" to view the test results
	5. You can also run individual tests - 
			Two profiles are created in pom.xml file - one for ui, and another for running api tests. If you want to run the ui and api tests individually, then type the following commands in cmd:
	* mvn clean install -P all <This will run all the tests (both api and ui) in the browser configured in serenity.properties file [webdriver.driver]>
	* mvn clean install -P ui <Will run only the ui tests>
	* mvn clean install -P api <Will run only the api tests>

	All above ways of running the tests will automatically generate the report
	
	**Note**
	If you are behind a corporate proxy, then you need to specify that in order to run the api tests. You can do that in the @Before setup method of CMSResponseSteps.java file with the 
	following line (uncomment the line):
	RestAssured.proxy = host("xx.xx.xxx").withPort(xxxx);
	
	
### Prerequisites:
	1. Java JDK 1.8 or higher
	2. Maven should be installed
	3. Edge and Firefox should be installed (If Firefox is not installed in the default directory, then specify the root directory (where FF is installed) in the serenity.properties file)
	4. All browsers should be latest versions (compatible with driver versions: Gecko: 0.19.1, Edge: 16229)