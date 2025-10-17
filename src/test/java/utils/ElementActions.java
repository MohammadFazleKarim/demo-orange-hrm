package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public ElementActions() {
        this.driver = DriverFactory.getDriver(); // use singleton driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void enterTextWithKeyActions(CharSequence keys) {
        actions.sendKeys(keys).perform();
    }

    public void scrollToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.scrollToElement(element).perform();
    }

    public void hoverOver(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }

}
