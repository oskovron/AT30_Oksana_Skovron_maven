package testHW9;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SearchFlightResultsPage;

public class FlightBookingTest extends BaseTest {

    @Test
    public void test(){
        String departureCity ="London";
        String destinationCity = "MYF";
        String flightClass = "business";
        int adultsNum = 2;
        int childrenNum = 1;
        int infantsNum = 1;

        homePage.searchFlights(departureCity, destinationCity, flightClass, adultsNum, childrenNum, infantsNum);

        System.out.println(driver.findElement(By.xpath("//*[@class='ml-auto']//button")).getText().toLowerCase());
        Assert.assertTrue(searchFlightResultsPage.modifySearchButtonGetText().contains("modify search"),
                "Search results page didn't load."); //npe ???
    }

    @Test
    public void draftTest(){
//        driver.get("https://www.phptravels.net/");
        homePage.goToFlightsTab();
//        homePage.clickClassDropdown();
//        homePage.clickClassBusinessDropdownItem();

        //pick date from calendar
        WebElement calendar = driver.findElement(By.xpath("//*[@id='FlightsDateStart']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", calendar);
        calendar.click();
        WebElement monthButton = driver.findElement(By.xpath("//*[@id='datepickers-container']"));
        monthButton.click();



        //Bad approach JS executor
//        ((JavascriptExecutor)driver)
//                .executeScript("document.getElementById('FlightsDateStart')" +
//                ".setAttribute('value','15 Dec 2020')");

    }
}
