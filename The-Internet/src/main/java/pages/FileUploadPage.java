package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By uploadButton = By.id("file-submit");
    private By inputField = By.id("file-upload");
    private By uploadedFile = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    private void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }

    /**
     * provides path of file to the form then clicks upload button
     * @param absolutePathOfFile complete path of the file to upload
     */
    public void uploadFile(String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedFile(){
        return driver.findElement(uploadedFile).getText();
    }
}
