package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.window.TabWindow;
import pages.demoqa.window.Windows;

public class WindowsTest extends TestBase{
    String url = "https://demoqa.com/browser-windows";
    String expectedText = "This is a sample page";
    String expectedTitle = "Browser Windows";
    String actualTitle;
    String actualText;
    Windows windows;
    TabWindow tabWindow;

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @Test
    public void tabWindowTest() {
        windows = new Windows(driver);
        tabWindow = new TabWindow(driver);
        windows.clickToTabButton();
        windows.switchToTab();
        actualText = tabWindow.getText();
        Assert.assertEquals(actualText, expectedText);
        windows.closeAndSwitchToOriginalWindow();
        actualTitle = windows.getMainTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
