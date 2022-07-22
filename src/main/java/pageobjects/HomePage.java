package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(xpath = "//*[@data-name='flights']")
    private WebElement flightsTab;

    @FindBy(xpath = "//*[@id='s2id_location_from']")
    private WebElement departureCityField;

    @FindBy(xpath = "//*[@id='select2-drop']//input")
    private WebElement departureCityInput;

    // bad one
    @FindBy(xpath = "//*[@class='select2-result-label']")
    private WebElement departureCityFirstResult;


    @FindBy(xpath = "//*[@id='s2id_location_to']")
    private WebElement destinationCityField;

    @FindBy(xpath = "//*[@id='select2-drop']//input")
    private WebElement destinationCityInput;

    @FindBy(xpath = "//*[@class='select2-result-label']")
    private WebElement getDestinationCityFirstResult;

    @FindBy(xpath = "//*[text()='Economy']/parent::a/parent::div")
    private WebElement classDropdown;

    @FindBy(xpath = "//*[contains(@class, 'active-result') and text()='First']")
    private WebElement classFirstDropdownItem;

    @FindBy(xpath = "//*[contains(@class, 'active-result') and text()='Business']")
    private WebElement classBusinessDropdownItem;

    @FindBy(xpath = "//*[contains(@class, 'active-result') and text()='Economy']")
    private WebElement classEconomyDropdownItem;

    @FindBy(xpath = "//*[contains(@class, 'active-result')]")
    private List<WebElement> classDropdownItemsList;

    @FindBy(xpath = "//input[@name='fadults']/parent::div//button[text()='+']")
    private WebElement adultsButtonPlus;

    @FindBy(xpath = "//input[@name='fchildren']/parent::div//button[text()='+']")
    private WebElement childButtonPlus;

    @FindBy(xpath = "//input[@name='finfant']/parent::div//button[text()='+']")
    private WebElement infantButtonPlus;

    @FindBy(xpath = "//*[@id='FlightsDateStart']")
    private WebElement departCalendar;

    @FindBy(xpath = "") //redundant?
    private WebElement nextMonthButtonCalendar;

    @FindBy(xpath = "")
    private WebElement monthSelectorButton;

    @FindBy(xpath = "")
    private WebElement yearSelectorButton;


    @FindBy(xpath = "//*[@name='flightmanualSearch']//button[contains(text(), 'Search')]")
    private WebElement searchButton;

    private void goToFlightsTab(){flightsTab.click();}
    private void enterDepartureCity(String city){
        departureCityField.click();
        departureCityInput.sendKeys(city); //"London"
        departureCityFirstResult.click();
    }
    private void enterDestinationCity(String city){
        destinationCityField.click();
        destinationCityInput.sendKeys(city, Keys.RETURN); //"MYF"
        getDestinationCityFirstResult.click();
    }

    private void clickClassDropdown(){
        classDropdown.click();
    }

    private void clickClassFirstDropdownItem(){
        classFirstDropdownItem.click();
    }

    private  void clickClassBusinessDropdownItem(){
        classBusinessDropdownItem.click();
    }

    private void clickClassEconomyDropdownItem(){
        classEconomyDropdownItem.click();
    }

    private void chooseClassFromDropdown(String className){
        classDropdownItemsList.stream()
                .filter(x -> x.getText().equalsIgnoreCase(className))
                .findFirst()
                .get()
                .click();
    }

    private void clickAdultsPlusButton(int numberOfAdults){
        for(int i=2; i<=numberOfAdults; i++) {
            adultsButtonPlus.click();
        }
    }

    private void clickChildPlusButton(int numberOfChildren) {
        for (int i = 1; i <= numberOfChildren; i++){
            childButtonPlus.click();
    }
    }

    private void clickInfantPlusButton(int numberOfInfants){
        for (int i=1; i<= numberOfInfants; i++) {
            infantButtonPlus.click();
        }
    }

    private void clickDepartCalendar(){
        departCalendar.click();
    }



    private SearchFlightResultsPage clickSearchButton(){
        searchButton.click();
        return PageFactory.initElements(driver, SearchFlightResultsPage.class);
    }

    //facade
    public SearchFlightResultsPage searchFlights(String departureCity, String destinationCity, String flightClass,
                                                 int adultsNum, int childrenNum, int infantsNum){
    goToFlightsTab();
    enterDepartureCity(departureCity);
    enterDestinationCity(destinationCity);
    clickClassDropdown();
    chooseClassFromDropdown(flightClass);
    clickAdultsPlusButton(adultsNum);
    clickChildPlusButton(childrenNum);
    clickInfantPlusButton(infantsNum);
    //choose date 15 DEC 2020
        return clickSearchButton();
    }
}
