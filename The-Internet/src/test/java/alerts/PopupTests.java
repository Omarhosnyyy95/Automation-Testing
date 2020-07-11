package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PopupTests extends BaseTests {

    @Test
    public void testPopupText(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnBox();
        String popupText = contextMenuPage.getPopupText();
        contextMenuPage.acceptPopup();
        assertEquals(popupText, "You selected a context menu","incorrect popup text");
    }
}
