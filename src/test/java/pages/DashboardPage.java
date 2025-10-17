package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.ElementActions;

public class DashboardPage {

    private ElementActions elementActions = new ElementActions();

    // Locators
    @FindBy(xpath = "//*[text()='Recruitment']")
    private WebElement recruitmentMenuLink;

    // Constructor
    public DashboardPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
        elementActions = new ElementActions();
    }

    // Actions
    public void navigateToRecruitment() {
        elementActions.clickElement(recruitmentMenuLink);
    }

}
