package tests;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.samplepagetest.SamplePage;

public class SelectTest extends TestBase{
    String value;
    SamplePage samplePage;

    String urlGlobalSqa = "https://www.globalsqa.com/samplepagetest/";

    @BeforeMethod
    public void precondition() {
        driver.get(urlGlobalSqa);
    }

    @Test
    public void selectTest() throws InterruptedException {
        samplePage = new SamplePage(driver);
        samplePage.selectValue("3-5");
        Thread.sleep(5000);
    }
}
