package testHW9;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseTest {
    private BaseTestAdmin baseTestAdmin;
    //Create test data
    String departureCity ="POS";
    String destinationCity = "MYF";
    String flightClass = "business";
    int adultsNum = 2;
    int childrenNum = 1;
    int infantsNum = 1;

    String firstName = "Oksana";
    String lastName = "Skovron";
    String email = "os@gmail.com";
    String contactNumber = "3547877";
    String address = "address 1 /7";
    String country = "Spain";
    String passengersName = "Passenger1";
    String passengersAge = "25";
    String passportNo = "ES58744";

    @Test
    public void testBooking(){
        //Go to Flights tab, enter data and click Search
        homePage.searchFlights(departureCity, destinationCity, flightClass, adultsNum, childrenNum, infantsNum);

        //Assert that search results page has opened.
        System.out.println(searchFlightResultsPage.modifySearchButtonGetText().toLowerCase());
        Assert.assertTrue(searchFlightResultsPage.modifySearchButtonGetText().contains("modify search"),
                "Search results page didn't load.");

        //Click "Book now" button on flight with cheapest flight
        searchFlightResultsPage.clickBookNowButton();
        //Assert that booking page has opened
        Assert.assertTrue(bookingPage.bookAsAGuestFormText().contains("book as a guest"), "Booking page didn't open.");

        //Fill in passengers' data
        bookingPage.enterPassengersData(firstName, lastName, email,email,contactNumber, address,
                country, passengersName, passengersAge, passportNo);

        //Assert that invoice page opened and booking status is unpaid
        Assert.assertTrue(invoicePage.payOnArrivalButtonText().contains("pay on arrival"), "Booking failed.");
    }

//    @Test
//    public void draftTest(){
//        driver.get("https://www.phptravels.net/");
//        homePage.goToFlightsTab();
//        homePage.clickClassDropdown();
//        homePage.clickClassBusinessDropdownItem();

//        //pick date from calendar
//        WebElement calendar = driver.findElement(By.xpath("//*[@id='FlightsDateStart']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", calendar);
////        calendar.click();
//        WebElement monthButton = driver.findElement(By.xpath("//*[@id='datepickers-container']"));
//        monthButton.click();
//


        //Bad approach JS executor
//        ((JavascriptExecutor)driver)
//                .executeScript("document.getElementById('FlightsDateStart')" +
//                ".setAttribute('value','15 Dec 2020')");

//    }
}
