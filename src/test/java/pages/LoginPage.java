package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.ElementActions;

public class LoginPage {

    private ElementActions elementActions = new ElementActions();

    // Locators
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    // Constructor
    public LoginPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
        elementActions = new ElementActions();
    }

    // Actions
    public void enterUsername(String username) {
        elementActions.enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        elementActions.enterText(passwordField, password);
    }

    public void clickLogin() {
        elementActions.clickElement(loginButton);
    }

    public void loginToHrm(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

}
