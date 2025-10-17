package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.ElementActions;

public class CandidateDetailPage {

    private ElementActions elementActions = new ElementActions();

    // Locators
    @FindBy(xpath = "//*[text()=' Shortlist ']")
    private WebElement shortListButton;

    @FindBy(xpath = "//*[text()=' Save ']")
    private WebElement saveButton;

    // Constructor
    public CandidateDetailPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
        elementActions = new ElementActions();
    }

    // Actions
    public void shortListCandidate() {
        elementActions.clickElement(shortListButton);
        elementActions.clickElement(saveButton);
    }

}
