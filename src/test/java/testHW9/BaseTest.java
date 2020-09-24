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
import pageobjects.HomePage;
import pageobjects.SearchFlightResultsPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected SearchFlightResultsPage searchFlightResultsPage;
    @BeforeClass
    @Parameters({"browser", "browserVersion", "environment"})
    public void setup(@Optional("CHROME") BrowserEnum browser, @Optional("85") String browserVersion,
                      @Optional("LOCAL") EnvironmentEnum environment) {
        driver = WebDriverFactory.getDriver(browser, browserVersion, environment);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/");
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().window().maximize();
    }

//    @AfterClass
//    public void teardown(){
//        driver.quit();
//    }
}
