package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }


    public String getResultText(){
        return driver.findElement(resultText).getText();
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    public String getConfirmText(){
        return driver.switchTo().alert().getText();
    }

    public void dismissJsAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void TriggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }

    public void setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }
}
