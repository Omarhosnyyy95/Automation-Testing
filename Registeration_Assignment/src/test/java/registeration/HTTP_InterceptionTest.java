package registeration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegisterationPage;
import utils.HarCapture;

import java.util.concurrent.TimeUnit;

public class HTTP_InterceptionTest{
    private WebDriver driver;
    private HomePage homePage;
    private HarCapture harCapture;

    // Valid input data
    String firstName = "Omar";
    String lastName = "Hosny";
    String mobileNumber = "01112223333";
    String mail = "ooommmaarrr_Hosnyyyyyy@gmail.com";
    String password = "Hello_123";
    String confirmPassword = "Hello_123";

    @BeforeClass
    private void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        harCapture = new HarCapture();
        ChromeOptions Options = harCapture.setUpProxy();
        driver = new ChromeDriver(Options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.get("https://www.phptravels.net/home/");
        harCapture.enableHarCapture(mobileNumber);
    }

    @Test
    public void testSuccessfulRegisteration(){

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
    }

    @AfterClass
    private void tearDown() {
        harCapture.captureHAR("resources/HAR_Files/" + firstName + "_" + lastName + ".har");
        if(driver != null){
            driver.quit();
        }
        harCapture.destroyProxy();
    }

}
