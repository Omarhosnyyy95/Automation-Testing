package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.tagName("input");
    private By span = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSpan(){
        return driver.findElement(span).getText();
    }

    public void sliderSteps(int steps){
        for(int i = 0; i < steps; i++){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }
}
