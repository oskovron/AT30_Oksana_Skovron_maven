package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFlightResultsPage {

    @FindBy(xpath = "//*[@class='ml-auto']//button")
    private WebElement modifySearchButton;

    private WebDriver driver;
    public SearchFlightResultsPage(WebDriver driver){this.driver=driver;}

    public String modifySearchButtonGetText(){
        return modifySearchButton.getText().toLowerCase();
    }
}
