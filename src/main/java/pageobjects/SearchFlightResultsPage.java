package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchFlightResultsPage {
    private WebDriver driver;
    private int minPrice;
    public SearchFlightResultsPage(WebDriver driver){this.driver=driver;}

    @FindBy(xpath = "//*[@class='ml-auto']//button")
    private WebElement modifySearchButton;

    @FindBy(xpath = "//*[@class='theme-search-results-item-price-tag']/strong")
    private List<WebElement> pricesList;

    @FindBy(xpath = "//*[text()='Book Now']")
    private List<WebElement> bookNowButtons;

    @FindBy(xpath = "//*[text()='Book Now']")
    private WebElement bookNowButton;

    public String modifySearchButtonGetText(){
        return modifySearchButton.getText().toLowerCase();
    }
    public void getPricesList(){
        System.out.println(pricesList);
    }
    public void getPrice(){
        for (WebElement e: pricesList) {
            String[] s = e.getText().split(" ");
            System.out.println(s);
        }
    }

    private int minPrice(){
        String[] s;
        List<String[]> listStringArray = new ArrayList<>();
        for (WebElement e: pricesList) {
            s = e.getText().split(" ");
            listStringArray.add(s);
        }
        minPrice = listStringArray.stream()
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> !(x.contains("USD")))
                .map(Integer::valueOf)
                .mapToInt(x -> x)
                .min()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(minPrice);
        return minPrice;
    }

    //Click "Book now" button on flight with cheapest flight
    public BookingPage clickBookNowButton(){
        minPrice();
        for (int i=0; i<pricesList.size(); i++){
            if (pricesList.get(i).getText().contains(String.valueOf(minPrice))){
                WebElement bookNowBnt = bookNowButtons.get(i);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", bookNowBnt);
                bookNowBnt.click();
                break;
            }
        }
        return PageFactory.initElements(driver, BookingPage.class);
    }

}
