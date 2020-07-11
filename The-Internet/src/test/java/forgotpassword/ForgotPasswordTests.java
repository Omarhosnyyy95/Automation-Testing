package forgotpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailVerificationPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertTrue;


public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testRetrievePassword(){
        var forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("omar_hello@myjava.org");
        var emailVerificationPage = forgotPasswordPage.clickRetrievePassword();
        assertTrue(emailVerificationPage.getPageContent().contains("Your e-mail's been sent!"), "Incorrect text");
    }
}
