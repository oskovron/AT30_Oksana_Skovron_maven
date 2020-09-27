package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookingPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    public BookingPage(WebDriver driver){this.driver=driver;}

    @FindBy(xpath = "//*[text()='Book as a Guest']")
    private WebElement bookAsAGuestForm;

    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(name = "lastname")
    private WebElement lastNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "confirmemail")
    private WebElement confirmEmailInput;

    @FindBy(name = "phone")
    private WebElement contactNumberInput;

    @FindBy(name = "address")
    private WebElement addressInput;

    @FindBy(xpath = "//*[@class='chosen-single']//*[text()='Select Country']")
    private WebElement selectCountryField;

    @FindBy(xpath = "//*[@class='chosen-search-input']")
    private WebElement countryInput;

    @FindBy(name = "country")
    private WebElement selectCountryDropdown; //??

    @FindBy(id = "passenger_name_0")
    private WebElement passengerNameInput;

    @FindBy(id = "passenger_age_0")
    private WebElement passengerAgeInput;

    @FindBy(id = "passenger_passport_0")
    private WebElement passportNumberInput;

    @FindBy(name = "guest")
    private WebElement confirmThisBookingButton;

    private void enterFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }
    private void enterLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }
    private void enterEmail(String email){
        emailInput.sendKeys(email);
    }
    private void confirmEmail(String confirmEmail){
        confirmEmailInput.sendKeys(confirmEmail);
    }
    private void enterContactNumber(String number){
        contactNumberInput.sendKeys(number);
    }
    private void enterAddress(String address){
        addressInput.sendKeys(address);
    }
    private void clickSelectCountryField(){
        selectCountryField.click();
    }
    private void selectOptionFromDropdown(String country){
        Select select = new Select(selectCountryDropdown);
        select.selectByVisibleText(country);
    }
    private void enterCountry(String country){
        countryInput.sendKeys(country + Keys.RETURN);
    }
    private void enterPassengersName(String passengerName){
        passengerNameInput.sendKeys(passengerName);
    }
    private void enterPassengersAge(String passengerAge){
        passengerAgeInput.sendKeys(passengerAge);
    }
    private void enterPassengersPassport(String passportNo){
        passportNumberInput.sendKeys(passportNo);
    }
    private  InvoicePage clickConfirmBookingButton(){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", confirmThisBookingButton);
        confirmThisBookingButton.click();
        return PageFactory.initElements(driver, InvoicePage.class);
    }

    public String bookAsAGuestFormText(){
        return bookAsAGuestForm.getText().toLowerCase();
    }


    //facade
    public InvoicePage enterPassengersData(String firstName, String lastName, String email, String confirmEmail,
                                    String contactNumber, String address, String country, String passengerName,
                                    String passengerAge, String passportNo){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        confirmEmail(confirmEmail);
        enterContactNumber(contactNumber);
        enterAddress(address);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", selectCountryField);
        clickSelectCountryField();
//        selectOptionFromDropdown(country); //??
        enterCountry(country);
        enterPassengersName(passengerName);
        enterPassengersAge(passengerAge);
        enterPassengersPassport(passportNo);
        return clickConfirmBookingButton();
    }
}
