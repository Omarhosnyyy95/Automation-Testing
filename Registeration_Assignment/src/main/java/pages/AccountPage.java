package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    private By welcomeTextField = By.className("text-align-left");
    private By dropdown = By.className("dropdown-login");
    private By logoutButton = By.linkText("Logout");
    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public String getWelcomeText(){
        return driver.findElement(welcomeTextField).getText();
    }
    public void selectLogoutFromDropdown(){
        driver.findElement(dropdown).click();
        driver.findElement(logoutButton).click();
    }
}
