package hooks;

import utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        DriverFactory.setDriver(driver);
    }

    @After
    public void tearDown() {
       // DriverFactory.quitDriver();
    }

}