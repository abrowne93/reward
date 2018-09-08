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
        adminEmployeePOM.setSearchBar("123456");
        adminEmployeePOM.clickSearchButton();
        String expected = "123456";
        String actual = adminEmployeePOM.getEmployeeNumber();
        Assert.assertEquals(expected, actual) ;
    }
}
