package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("E:\\testautomationu\\webdriver_java\\resources\\chromedriver.exe");
        assertEquals(fileUploadPage.getUploadedFile(), "chromedriver.exe", "incorrect file");
    }
}
