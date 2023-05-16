package tests.apple;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.apple.ApplePage;
import tests.TestBase;

public class AppleTest extends TestBase {
    String url = "https://appleinsider.ru/";
    String text = "Apple";
    ApplePage applePage;

    @BeforeMethod
    public void open() {
        driver.get(url);

    }

    @Test
    public void appleTest() throws InterruptedException {
        applePage = new ApplePage(driver);
        applePage.fillSearch(text);
        System.out.println("ndnd");
    }

    @Test
    public void apple2Test() throws InterruptedException {
        applePage = new ApplePage(driver);
        applePage.fillWithJs();
        System.out.println("ndnd");
    }

}
