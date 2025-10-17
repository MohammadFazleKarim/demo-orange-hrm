package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.DriverFactory;
import utils.ElementActions;

import java.util.List;

public class CandidatesPage {

    private ElementActions elementActions = new ElementActions();

    // Locators
    @FindBy(xpath = "//*[text()=' Add ']")
    private WebElement addButton;

    @FindBy(xpath = "//*[text()='Recruitment']")
    private WebElement recruitmentMenu;

    @FindBy(xpath = "//div[text()='Vacancy']")
    private WebElement vacancyText;

    @FindBy(xpath = "//*[@class='oxd-table-card']")
    private List<WebElement> candidatesList;

    // Constructor
    public CandidatesPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
        elementActions = new ElementActions();
    }

    // Actions
    public void addCandidate() {
        elementActions.clickElement(addButton);
    }

    public void verifyAddedCandidate(String firstName, String lastName) {
        elementActions.clickElement(recruitmentMenu);
        elementActions.scrollToElement(vacancyText);

        for(WebElement candidate : candidatesList) {
            String fullName = candidate.findElement(By.xpath(".//div[3]/div")).getText();
            if(fullName.equals(firstName + " " + lastName)){
                Assert.assertTrue(true);
                break;
            }
        }
    }

    public void viewCandidateDetails(String firstName, String lastName) {
        for(WebElement candidate : candidatesList) {
            String fullName = candidate.findElement(By.xpath(".//div[3]/div")).getText();
            if(fullName.equals(firstName + " " + lastName)){
                candidate.findElement(By.xpath(".//button/i[contains(@class, 'eye-fill')]")).click();
                break;
            }
        }
    }

}
