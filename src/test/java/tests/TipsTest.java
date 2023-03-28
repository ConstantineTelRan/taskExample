package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.samplepagetest.SamplePage;

import static java.lang.Thread.sleep;

public class TipsTest  extends TestBase {
    String text = "Please fill out this field.";
    SamplePage samplePage;

    @BeforeMethod
    public void openUrl() {
        driver.get("https://www.globalsqa.com/samplepagetest/");
    }

    @Test
    public void textTest() throws InterruptedException {
        samplePage = new SamplePage(driver);
        samplePage.submitButtonClick();
//        sleep(30000);
        Assert.assertTrue(driver.getPageSource().contains(text));
    }
}
