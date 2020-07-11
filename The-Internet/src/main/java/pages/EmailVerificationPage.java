package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailVerificationPage {
    private WebDriver driver;
    private By content = By.id("content");

    public EmailVerificationPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageContent(){
       return driver.findElement(content).getText();
    }
}
