package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiWyg(){
        var wysiwygPage = homePage.clickWYSIWYGEditor();
        String text1 = "Hello ";
        String text2 = "world";
        wysiwygPage.clearTextArea();
        wysiwygPage.setTextArea(text1);
        wysiwygPage.clickDecreaseIndent();
        wysiwygPage.setTextArea(text2);
        assertEquals(wysiwygPage.getTextFromEditor(), text1+text2, "incorrect text");
    }
}
