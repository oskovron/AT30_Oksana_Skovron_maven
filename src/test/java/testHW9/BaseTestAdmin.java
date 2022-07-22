package testHW9;

import core.WebDriverFactory;
import enums.BrowserEnum;
import enums.EnvironmentEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

public class BaseTestAdmin {
    protected WebDriver driver;
    protected AdminLoginPage adminLoginPage;
    protected AdminWelcomePage adminWelcomePage;

    @BeforeClass
    @Parameters({"browser", "browserVersion", "environment"})
    public void setup(@Optional("CHROME") BrowserEnum browser, @Optional("85") String browserVersion,
                      @Optional("LOCAL") EnvironmentEnum environment) {
        driver = WebDriverFactory.getDriver(browser, browserVersion, environment);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/admin");
        adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        adminWelcomePage = PageFactory.initElements(driver, AdminWelcomePage.class);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
