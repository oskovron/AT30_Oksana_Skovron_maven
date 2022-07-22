package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoicePage {

    private WebDriver driver;
    public InvoicePage(WebDriver driver){this.driver=driver;}

    @FindBy(xpath = "//*[text()='Pay on Arrival']")
    private WebElement payOnArrivalButton;

    public String payOnArrivalButtonText(){
        return payOnArrivalButton.getText().toLowerCase();
    }
}
