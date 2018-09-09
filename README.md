# reward

I have implemented Selenium Tests for the Admin Employee UI and provided a file with other examples of Test Scenarios that should be run. Cucumber has not been implemented, instead an example of what the test would look like is provided in the Design Document.

Files:
Design Document.docx
This is the design document which includes the technologies I would use. It also contains Assumptions that I made.

src/PageObjects/AdminEmployeePOM.java
This file contains a PageObject Model for the Admin Employee UI.
Each UI element is found using @FindBy(name="searchBar"). Ideally I would use the XPath for this, but because the UI doesn't exist, I just used names for now.
Along with this, there are support methods that are called to enter and get text from fields as well as click the buttons on the UI.

src/AdminEmployeeTests.java 
This file contains the Tests that use the above PageObject Model.
At present, this is setup just to use ChromeDriver. Ideally this would be changed to do each test with Firefox, Chrome and Internet Explorer.
I've implemented a few of the tests fully to show what they do. The rest of the tests are in

testScenarios.xlsx
This file contains a Matrix of all the Test Scenarios that I would use on this application.
Note: I've covered all the ones for the Admin Employee UI and Admin Assign Performance Reviews.
