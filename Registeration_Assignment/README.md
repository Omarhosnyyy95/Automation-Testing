# RegisterationAssignment

### Environment:
- **IDE**: IntelliJ.
- **Compiler**: Java 14.
- **Target Domain**: https://phptravels.net/.
- **Web driver**: Chrome driver.
- **Web browser**: Chrome browser.
- **Dependencies**: selenium-chrome-driver, selenium-support, testng, browsermob-core.
- **Design pattern**: Page Object Model.
### Solution:
#### The solution has 2 test classes:
- ***'HTTP_InterceptionTest'***: class which works by setting up a proxy server before running any tests to intercept the HTTP requests and capturing the response and then saving it in a .har file in resources/HAR_Files/. After entering valid data to the test you can open the .har file which is saved with the name 'firstName_lastName'.har _(firstName and lastName are those used in the test)_ and manually try to find any data you entered. You will find them at the bottom of the response.
- ***'RegisterationTest'*** class which includes number of test cases to test registeration without using a proxy server 
as there is no need to do. Session ends after each test case and a screenshot is taken in case of test failure 
and saved in resources/screenshots. Reporting of the tests takes place in the console by implementing ITestListner interface.
### Components:
#### resources:

- ***HAR_Files***: contains the result response when intercepting an HTTP request to save registeration data in a format 'userFirstName'_'userLastName'.har
- ***screenshots***: contains all the screenshots from failed tests saved in 'testName'.png format
- ***chromedriver***

#### src/main/java/pages:
- ***HomePage class***: required properties and methods to interact with dropdown and get to RegisterationPage
- ***RegisterationPage class***: required properties and methods to interact with input data and get outputs needed for assesrtion
- ***AccountPage class***: required properties and methods to get welcome text and recover from sign in account page to signout and start a new test

#### src/main/java/utils:
- ***EventReporter class***: an implementation of the ITestListner interface to automatically generate a report in the console
- ***HarCapture class***: contains the required methods to intercept and HTTP request and capture the response in a HAR file.

#### src/test/java/registeration:
- ***HTTP_InterceptionTest class***: contains the setup of a proxy server before initiating the test to intercept the HTTP request and capture the response.
- ***RegisterationTest class***: contains all the setup before and after test and the test cases for registeration without using proxy server.

### Limitations:
- The script is designed to work on just 1 browser _(Google Chrome)_.
- Test data is not dynamic enough they are just stored in variables inside the test functions and not extracted
  from a more dynamic object such as a json object.
- Report is generated on the console by implementing ITestListner interface and not saved and refined in a file format.
- every test class has its own setup because I didn't want to generalize using proxy server in all my tests as it
  slows down the test. So I went for setting up the before and after test in each test class individually.
