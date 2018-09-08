import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import PageObjects.AdminEmployeePOM;

public class AdminEmployeeTests {
    WebDriver driver;
    AdminEmployeePOM adminEmployeePOM;

    /**
     * Sets up the environment before each test run.
     * By default it uses the ChromeDriver.
     * An implicitWait is provided. This polls the page for 10 seconds and continues when the element has loaded. If it
     * is not present after 10 seconds, it times out.
     * Finally the driver navigates to the URL for the application under test.
     */
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/admin/employee/");
    }

    /**
     * Clears down the environment after each test run.
     * The driver object is closed.
     */
    @AfterTest
    public void tearDown() {
        driver.close();
    }

    /**
     * This test checks that the Search Bar works when entering an Employee ID.
     * The Search Bar is populated with the Employee ID (123456). And the Search Button is then clicked.
     * Finally, we get the Employee Number from the UI.
     * An Assertion is made to ensure that the EmployeeNumber in the field equals 123456.
     */
    @Test (priority = 0)
    public void test_searchEmployeeByIDValid() {
        String expected = "123456";
        adminEmployeePOM.setSearchBar(expected);
        adminEmployeePOM.clickSearchButton();
        String actual = adminEmployeePOM.getEmployeeNumber();
        Assert.assertEquals(expected, actual) ;
    }

    /**
     * This test checks that the Search Bar works when entering an Employee ID that doesn't exist.
     * The search bar is populated with the Employee ID. And then the Search Button is clicked.
     * Finally we Assert that the Employee Number field on the UI is Empty.
     */
    @Test (priority = 0)
    public void test_searchEmployeeByIDInvalid() {
        adminEmployeePOM.setSearchBar("125481854811");
        adminEmployeePOM.clickSearchButton();
        Assert.assertTrue(adminEmployeePOM.getEmployeeNumber().isEmpty());
    }

    /**
     * This test checks that the Search Bar works when entering an Employee Name.
     * The Search Bar is populated with the Employee Name (Anthony). And the Search Button is then clicked.
     * Finally, we get the Employee Name from the UI.
     * An Assertion is made to ensure that the EmployeeName in the field equals Anthony.
     */
    @Test (priority = 0)
    public void test_searchEmployeeByNameValid() {
        String expected = "Anthony";
        adminEmployeePOM.setSearchBar(expected);
        adminEmployeePOM.clickSearchButton();
        String actual = adminEmployeePOM.getFirstName();
        Assert.assertEquals(expected, actual);
    }
    /**
     * This test checks that the Search Bar works when entering an Employee Name that doesn't exist.
     * The search bar is populated with the Employee Name. And then the Search Button is clicked.
     * Finally we Assert that the Employee Name field on the UI is Empty.
     */
    @Test (priority = 0)
    public void test_searchEmployeeByNameInvalid() {
        adminEmployeePOM.setSearchBar("Aaabbbcccddd");
        adminEmployeePOM.clickSearchButton();
        Assert.assertTrue(adminEmployeePOM.getFirstName().isEmpty());
    }

    /**
     * This test creates a new Employee.
     * It calls the support_CreateEmployee method to create it.
     * It asserts that each field on the UI matches what was entered in the Test Data.
     */
    @Test (priority = 0)
    public void test_createEmployee(){
        String firstName = "John";
        String surName = "Smith";
        String employeeNumber = "12343356";
        String email = "john@smith.com";
        String phoneNumber = "01234567890";
        support_CreateEmployee(firstName, surName, employeeNumber, email, phoneNumber);
        Assert.assertEquals(firstName, adminEmployeePOM.getFirstName());
        Assert.assertEquals(surName, adminEmployeePOM.getSurName());
        Assert.assertEquals(employeeNumber, adminEmployeePOM.getEmployeeNumber());
        Assert.assertEquals(email, adminEmployeePOM.getEmail());
        Assert.assertEquals(phoneNumber, adminEmployeePOM.getPhoneNumber());
    }

    /**
     * This test creates then deletes an Employee.
     * It calls the support_CreateEmployee method.
     * After Delete has been clicked, it searches for the employee by the ID Number.
     * Finally we assert that the First Name field is blank.
     */
    @Test (priority = 0)
    public void test_deleteEmployee() {
        String firstName = "John";
        String surName = "Smith";
        String employeeNumber = "12343356";
        String email = "john@smith.com";
        String phoneNumber = "01234567890";
        support_CreateEmployee(firstName, surName, employeeNumber, email, phoneNumber);
        adminEmployeePOM.clickDelete();
        adminEmployeePOM.setSearchBar(employeeNumber);
        adminEmployeePOM.clickSearchButton();
        Assert.assertTrue(adminEmployeePOM.getFirstName().isEmpty());
    }

    /**
     * This test creates then edits an Employee.
     * It calls the support_CreateEmployee method.
     * After the employee is created, the edit button is clicked. The value of the Email field is changed.
     * Save is then clicked.
     * Finally it Asserts that the Email field is not displaying the new email address.
     */
    @Test (priority = 0)
    public void test_editEmployee() {
        String firstName = "John";
        String surName = "Smith";
        String employeeNumber = "12343356";
        String email = "john@smith.com";
        String phoneNumber = "01234567890";
        String newEmail = "Smith@John.co.uk";
        support_CreateEmployee(firstName, surName, employeeNumber, email, phoneNumber);
        adminEmployeePOM.clickEdit();
        adminEmployeePOM.setEmail(newEmail);
        adminEmployeePOM.clickSave();
        Assert.assertEquals(newEmail, adminEmployeePOM.getEmail());
    }

    /**
     * This support method creates a New Employee on the UI.
     * It takes all the data as the parameters then puts it into the Interface.
     * Finally we click the Create button.
     * @param firstName String for the Employees First Name
     * @param surName String for the Employees Surname
     * @param employeeNumber String for the Employees Phone Number
     * @param email String for the Employees Email Address
     * @param phoneNumber String for the Employees phoneNumber
     */
    private void support_CreateEmployee(String firstName, String surName, String employeeNumber, String email,
                                        String phoneNumber) {
        adminEmployeePOM.clickAdd();
        adminEmployeePOM.setFirstName(firstName);
        adminEmployeePOM.setSurName(surName);
        adminEmployeePOM.setEmployeeNumber(employeeNumber);
        adminEmployeePOM.setEmail(email);
        adminEmployeePOM.setPhoneNumber(phoneNumber);
        adminEmployeePOM.clickCreate();
    }
}
