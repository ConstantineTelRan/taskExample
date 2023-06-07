package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.book_store.BookLoginPage;
import pages.demoqa.book_store.ProfilePage;

public class BrowserTest extends TestBase{
    BookLoginPage bookLoginPage;
    ProfilePage profilePage;
    BookLoginPage bookLoginPage2;
    WebDriver driver2;

    @BeforeMethod
    public void precondition() {
        driver.get("https://demoqa.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='70%'");
    }

    @Test
    public void browserTest() {
        bookLoginPage = new BookLoginPage(driver);
        bookLoginPage.loginToBookStore();
        driver2 = getSecondDriver();
        driver2.get("https://demoqa.com/login");
        bookLoginPage2 = new BookLoginPage(driver2);
        bookLoginPage2.loginToBookStore();
        profilePage = new ProfilePage(driver2);
        profilePage.clickToLogOutButton();
        driver2.quit();
    }

    @Test
    public void browserTest2() {
        bookLoginPage = new BookLoginPage(driver);
        bookLoginPage.loginToBookStore();
        profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.logOutButton.isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://demoqa.com/login','_blank');");
        String originalWindow = bookLoginPage.getOriginalWindow();
        bookLoginPage.switchToNewTab(originalWindow);
        Assert.assertEquals(bookLoginPage.getInfoText(), "You are already logged in. View your profile.");
    }

}
