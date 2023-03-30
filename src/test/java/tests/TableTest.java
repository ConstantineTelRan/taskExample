package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.TablePage;

public class TableTest extends TestBase {
    String url = "https://demoqa.com/webtables";

    TablePage tablePage;

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @Test
    public void tableTest() {
        tablePage = new TablePage(driver);
        tablePage.printData();
    }

}
