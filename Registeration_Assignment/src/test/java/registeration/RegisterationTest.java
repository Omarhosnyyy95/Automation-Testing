package registeration;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.HomePage;
import pages.RegisterationPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

@Listeners(utils.EventReporter.class)

public class RegisterationTest{

    private WebDriver driver;
    private HomePage homePage;

    private void tearDown(){
        driver.quit();
    }
    private void goHome(){
        driver.get("https://www.phptravels.net/home/");
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    private void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        goHome();
    }
    @AfterMethod
    private void recoverAndTakeScreenshot(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }

        }
        if(driver.getTitle().equalsIgnoreCase("My Account")){
            new AccountPage(driver).selectLogoutFromDropdown();
        }
        tearDown();
    }

    @Test
    public void testValidData(){
        // Test Data
        String firstName = "Omar";
        String lastName = "Ahmed";
        String mobileNumber = "01112223333";
        String mail = "ooooommmmmaarrrrrr_Ahhhhmed_Hosny@welcommmmeee.com";
        String password = "Hello_123";
        String confirmPassword = "Hello_123";

        // go to registeration page
        RegisterationPage registerationPage = homePage.SelectRegisterFromDropdown();
        // set input data
        registerationPage.setFirstname(firstName);
        registerationPage.setLastname(lastName);
        registerationPage.setMobileNumber(mobileNumber);
        registerationPage.setEmail(mail);
        registerationPage.setPassword(password);
        registerationPage.setConfirmPassword(confirmPassword);
        // submit
        var accountPage = registerationPage.clickSignupButton();
        Assert.assertTrue(accountPage.getWelcomeText().contains(firstName + " " + lastName));
    }
    @Test(priority = 1)
    public void testAlreadyExistingEmail(){
        // Test Data
        String firstName = "Omar";
        String lastName = "Ahmed";
        String mobileNumber = "01112223333";
        String mail = "oooomaaarrrr_Ahhhhmmmed_Hosny@welcommmmeee.com";   // same email address as the valid test
        String password = "Hello_123";
        String confirmPassword = "Hello_123";

        // go to registeration page
        RegisterationPage registerationPage = homePage.SelectRegisterFromDropdown();
        // set input data
        registerationPage.setFirstname(firstName);
        registerationPage.setLastname(lastName);
        registerationPage.setMobileNumber(mobileNumber);
        registerationPage.setEmail(mail);
        registerationPage.setPassword(password);
        registerationPage.setConfirmPassword(confirmPassword);
        // submit
        registerationPage.clickSignupButton();
        Assert.assertTrue(registerationPage.getAlertText().contains("Email Already Exists."));
    }
    @Test(priority = 2)
    public void testBlankFields(){
        // go to registeration page
        RegisterationPage registerationPage = homePage.SelectRegisterFromDropdown();
        // set input data
        // submit
        registerationPage.clickSignupButton();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Register");
    }
    @Test(priority = 3)
    public void testFirstNameEqualslastName(){
        // Test Data
        String firstName = "Omar";
        String lastName = "Omar";
        String mobileNumber = "01112223333";
        String mail = "ooommaaaarrrrr_Ahhhmmmed_Hosnyyy@weeelcommmmeee.com";    // new email address
        String password = "Hello_123";
        String confirmPassword = "Hello_123";

        // go to registeration page
        RegisterationPage registerationPage = homePage.SelectRegisterFromDropdown();
        // set input data
        registerationPage.setFirstname(firstName);
        registerationPage.setLastname(lastName);
        registerationPage.setMobileNumber(mobileNumber);
        registerationPage.setEmail(mail);
        registerationPage.setPassword(password);
        registerationPage.setConfirmPassword(confirmPassword);
        // submit
        registerationPage.clickSignupButton();
        assertEquals(driver.getTitle(), "Register");
    }

}