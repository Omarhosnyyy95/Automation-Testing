package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterationPage{

    private WebDriver driver;

    // locating web elements
    private By firstnameField = By.name("firstname");
    private By lastnameField = By.name("lastname");
    private By mobileNumberField = By.name("phone");
    private By mailField = By.name("email");
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.name("confirmpassword");
    private By signupButton = By.className("btn_full");
    private By alertText = By.className("alert-danger");

    // RegisterationPage constructor
    public RegisterationPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * this function sets an element to an input value
     * @param element
     * @param input
     */
    private void setElement(By element, String input){
        driver.findElement(element).sendKeys(input);
    }

    // setting inputs
    public void setFirstname(String firstName){
        setElement(firstnameField, firstName);
    }
    public void setLastname(String lastName){
        setElement(lastnameField, lastName);
    }
    public void setMobileNumber(String mobileNumber){
        setElement(mobileNumberField, mobileNumber);
    }
    public void setEmail(String mail){
        setElement(mailField, mail);
    }
    public void setPassword(String password){
        setElement(passwordField, password);
    }
    public void setConfirmPassword(String confirmPassword){
        setElement(confirmPasswordField, confirmPassword);
    }

    // click sign up button and go to your account page
    // element was not clickable till I used javascript
    public AccountPage clickSignupButton(){
        WebElement signup = driver.findElement(signupButton);
        // using js to click on the element
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", signup);
        return new AccountPage(driver);
    }

    public String getAlertText(){
        return driver.findElement(alertText).getText();
    }

}
