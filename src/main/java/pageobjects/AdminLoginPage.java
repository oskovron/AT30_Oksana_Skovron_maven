package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
    private WebDriver driver;
    public AdminLoginPage(WebDriver driver){this.driver=driver;}

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    private void enterEmail(String email){
        emailInput.sendKeys(email);
    }
    private void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    private AdminWelcomePage clickLoginButton(){
        loginButton.click();
        return PageFactory.initElements(driver, AdminWelcomePage.class);
    }

    public AdminWelcomePage loginAs(String email, String password){
        enterEmail(email);
        enterPassword(password);
        return clickLoginButton();
    }
}
