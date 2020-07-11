package hover;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTest extends BaseTests {

    @Test
    public void testHoverUser1(){
        HoversPage hoversPage = homePage.clickHovers();
        var figureCaption = hoversPage.hoverOverFigure(1);

        String header = "name: user1";
        String linkText = "View profile";
        String linkEnd = "/users/1";

        assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed");
        assertEquals(figureCaption.getName(), header, "Name is incorrect");
        assertEquals(figureCaption.getLinkText(), linkText, "Link text is incorrect");
        assertTrue(figureCaption.getLink().endsWith(linkEnd), "Link path is incorrect");

    }
}
