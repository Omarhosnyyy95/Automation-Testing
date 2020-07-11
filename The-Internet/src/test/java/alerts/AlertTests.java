package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import java.util.SplittableRandom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertTests extends BaseTests {
    @Test
    public void testAcceptAlert(){
        AlertsPage alertsPage = homePage.clickJSAlerts();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        assertTrue(alertsPage.getResultText().contains("You successfuly clicked an alert"), "Invalid result text");
    }

    @Test
    public void testGetTextFromAlert(){
        AlertsPage alertsPage = homePage.clickJSAlerts();
        alertsPage.triggerConfirm();
        String alertText = alertsPage.getConfirmText();
        alertsPage.dismissJsAlert();
        assertEquals(alertText, "I am a JS Confirm", "incorrect alert text");
        assertEquals(alertsPage.getResultText(), "You clicked: Cancel", "incorrect result text");
    }

    @Test
    public void testInputInAlert(){
        var alertsPage = homePage.clickJSAlerts();
        alertsPage.TriggerPrompt();
        String inputText = "Hello, Omar";
        alertsPage.setInput(inputText);
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResultText(), "You entered: " + inputText, "incorrect result");
    }
}
