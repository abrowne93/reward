package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminEmployeePOM {
    WebDriver driver;

    // WebElement Object to store the Search Bar Element.
    @FindBy(name="searchBar")
    WebElement searchBar;

    // WebElement Object to store the Search Button Element.
    @FindBy(name="searchButton")
    WebElement searchButton;

    // WebElement Object to store the Add Button Element.
    @FindBy(name="add")
    WebElement add;

    // WebElement Object to store the First Name Text Field.
    @FindBy(name="firstName")
    WebElement firstName;

    // WebElement Object to store the Surname Text Field.
    @FindBy(name="surName")
    WebElement surName;

    // WebElement Object to store the Employee Number Text Field.
    @FindBy(name="employeeNumber")
    WebElement employeeNumber;

    // WebElement Object to store the Phone Number Text Field.
    @FindBy(name="phoneNumber")
    WebElement phoneNumber;

    // WebElement Object to store the Email Text Field.
    @FindBy(name="email")
    WebElement email;

    // WebElement Object to store the Edit Button Object.
    @FindBy(name="edit")
    WebElement edit;

    // WebElement Object to store the Delete Button Object.
    @FindBy(name="delete")
    WebElement delete;

    // WebElement Object to store the Create Button Object.
    @FindBy(name="create")
    WebElement create;

    // WebElement Object to store the Save Button Object.
    @FindBy(name="save")
    WebElement save;

    /**
     * Initialises the class. Assigns the provided driver to the local class.
     * Initialises the PageFactory for the class variables.
     * @param driver The driver instance for the test.
     */
    public AdminEmployeePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Sets the value in the Search Bar on the UI.
     * @param searchString The value to be put in the Search Bar.
     */
    public void setSearchBar(String searchString) {
        searchBar.sendKeys(searchString);
    }

    /**
     * Clicks on the Search Button on the UI.
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * Clicks on the Add Button on the UI.
     */
    public void clickAdd() {
        add.click();
    }

    /**
     * Sets the value in the First Name Text Field.
     * @param firstNameString The value to be put in the First Name Field.
     */
    public void setFirstName(String firstNameString) {
        firstName.sendKeys(firstNameString);
    }

    /**
     * Gets the value that is in the First Name Field.
     * @return String with the First Name.
     */
    public String getFirstName() {
        return firstName.getText();
    }

    /**
     * Sets the provided value in the Surname Text Field.
     * @param surNameString The Surname to be entered.
     */
    public void setSurName(String surNameString) {
        surName.sendKeys(surNameString);
    }

    /**
     * Gets the value that is in the Surname Field.
     * @return String with the Surname.
     */
    public String getSurName() {
        return surName.getText();
    }

    /**
     * Sets the value of the Employee Number field.
     * @param employeeNumberString String with the Employee Number.
     */
    public void setEmployeeNumber(String employeeNumberString) {
        employeeNumber.sendKeys(employeeNumberString);
    }

    /**
     * Gets the value of the Employee Number field.
     * @return String with the Employee Number.
     */
    public String getEmployeeNumber() {
        return employeeNumber.getText();
    }

    /**
     * Sets the value of the Phone Number field.
     * @param phoneNumberString The value of the Phone Number to be entered.
     */
    public void setPhoneNumber(String phoneNumberString) {
        phoneNumber.sendKeys(phoneNumberString);
    }

    /**
     * Gets the value of the Phone Number field.
     * @return String with the Phone Number.
     */
    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    /**
     * Sets the value of the Email field.
     * @param emailString The value of the Email field to be entered.
     */
    public void setEmail(String emailString) {
        email.sendKeys(emailString);
    }

    /**
     * Gets the value of the Email field.
     * @return String with the value of the Email field.
     */
    public String getEmail() {
        return email.getText();
    }

    /**
     * Clicks on the Edit button on the UI.
     */
    public void clickEdit() {
        edit.click();
    }

    /**
     * Clicks on the Delete button on the UI.
     */
    public void clickDelete() {
        delete.click();
    }

    /**
     * Clicks on the Create button on the UI.
     */
    public void clickCreate() {
        create.click();
    }

    /**
     * Clicks on the Save button on the UI.
     */
    public void clickSave() {
        save.click();
    }
}