package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.demoqa.window.BrowserWindowsPage;
import pages.demoqa.window.NewTabPage;

public class WindowTests extends TestBase {
    String url = "https://demoqa.com/browser-windows/";
    String expectedNewTabText = "This is a sample page";
    String actualNewTabText;
    String expectedOriginalTabText = "Browser Windows";
    String actualOriginalTabText;
    String originalWindow;

    BrowserWindowsPage browserWindowsPage;
    NewTabPage newTabPage;

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }


    @Test
    public void newTabTest() {
        browserWindowsPage = new BrowserWindowsPage(driver);
        originalWindow = browserWindowsPage.getOriginalWindow();
        browserWindowsPage.clickToNewTabButton();
        browserWindowsPage.switchToNewTab(originalWindow);
        newTabPage = new NewTabPage(driver);
        actualNewTabText = newTabPage.getHeaderText();
        Assert.assertEquals(actualNewTabText, expectedNewTabText);
        newTabPage.closeAndSwitchToOriginalWindow(originalWindow);
        actualOriginalTabText = browserWindowsPage.getMainHeaderText();
        Assert.assertTrue(browserWindowsPage.isMainHeader());
        Assert.assertEquals(actualOriginalTabText, expectedOriginalTabText);
    }

}
