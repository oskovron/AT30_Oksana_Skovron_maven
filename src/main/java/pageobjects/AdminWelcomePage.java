package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminWelcomePage {
    private WebDriver driver;
    public AdminWelcomePage(WebDriver driver){this.driver=driver;}

    @FindBy(xpath = "//*[@id='social-sidebar-menu']//a[contains(@href, 'admin/bookings')]")
    private WebElement bookingsLinkSideBar;

    private void clickBookingsLinkSideBar(){
        bookingsLinkSideBar.click();
    }
}
