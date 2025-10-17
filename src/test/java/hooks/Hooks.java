package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    public static WebDriver driver;
    private ElementActions elementActions;

    public Hooks() {
        elementActions = new ElementActions();
    }

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        DriverFactory.setDriver(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterStep
    public void endStep(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
    }

    private void takeScreenshot(Scenario scenario) {
        try {
            // Timestamp for unique file name
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".png";

            // Screenshot path
            String screenshotPath = System.getProperty("user.dir") + "/target/screenshots/" + screenshotName;

            // Create directories if not exist
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/target/screenshots/"));

            // Take screenshot and save
            File srcFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            Files.copy(srcFile.toPath(), Paths.get(screenshotPath));

            // Attach to Cucumber report
            scenario.attach(Files.readAllBytes(Paths.get(screenshotPath)), "image/png", screenshotName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}