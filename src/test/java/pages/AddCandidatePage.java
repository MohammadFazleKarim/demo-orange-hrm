package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.ElementActions;

public class AddCandidatePage {

    private ElementActions elementActions = new ElementActions();

    // Locators
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[text()='Vacancy']")
    private WebElement vacancyLabel;

    @FindBy(xpath = "//*[text()='Senior QA Lead']")
    private WebElement positionName;

    @FindBy(xpath = "//*[text()='Email']")
    private WebElement emailLabel;

    @FindBy(css = "[type='file']")
    private WebElement resumeUploadInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    // Constructor
    public AddCandidatePage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
        elementActions = new ElementActions();
    }

    // Actions
    public void enterFirstName(String firstName) {
        elementActions.enterText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        elementActions.enterText(lastNameField, lastName);
    }

    public void chooseVacancy() {
        elementActions.clickElement(vacancyLabel);
        elementActions.enterTextWithKeyActions(Keys.TAB);
        elementActions.clickElement(positionName);
    }

    public void enterEmail(String email) {
        elementActions.clickElement(emailLabel);
        elementActions.enterTextWithKeyActions(Keys.TAB + email);
    }

    public void enterResume(String resumePath) {
        if (resumePath != null && !resumePath.isEmpty()) {
            elementActions.enterText(resumeUploadInput, resumePath);
        }
    }

    public void saveCandidate() {
        elementActions.clickElement(saveButton);
    }

    public void fillCandidateForm(String firstName, String lastName, String email, String resumePath) {
        enterFirstName(firstName);
        enterLastName(lastName);
        chooseVacancy();
        enterEmail(email);
        enterResume(resumePath);
    }

}
