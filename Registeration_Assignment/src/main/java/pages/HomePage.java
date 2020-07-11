package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginDropdown = By.className("dropdown-login");
    private By registerOption = By.linkText("Sign Up");

    // HomePage constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * select registeration option from dropdown
     * Select class is not used because the html does not have <option> tag
     * @return
     */
    public RegisterationPage SelectRegisterFromDropdown(){
        driver.findElement(loginDropdown).click();
        driver.findElement(registerOption).click();
        return new RegisterationPage(driver);
    }
}
