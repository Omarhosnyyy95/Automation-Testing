package slider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SliderTests extends BaseTests {
    @Test
    public void testSlider(){
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.sliderSteps(8);
        assertTrue(sliderPage.getSpan().contains("4"), "incorrect number");
    }
}
