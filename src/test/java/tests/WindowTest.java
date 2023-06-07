package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.book_store.BookLoginPage;
import pages.demoqa.book_store.ProfilePage;

public class WindowTest extends TestBase{
    BookLoginPage bookLoginPage;
    BookLoginPage bookLoginPage2;
    ProfilePage profilePage;
    String originalWindow;
    WebDriver driver2;


    @BeforeMethod
    public void precondition() {
        driver.get("https://demoqa.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='70%'");
    }

    @Test
    public void windowTest() {
        bookLoginPage = new BookLoginPage(driver);
        bookLoginPage.loginToBookStore();
        driver2 = getSecondDriver();
        driver2.get("https://demoqa.com/login");
        bookLoginPage2 = new BookLoginPage(driver2);
        bookLoginPage2.loginToBookStore();
        profilePage = new ProfilePage(driver2);
        profilePage.clickToLogOutButton();

        System.out.println("jkdjdjdjd");
        driver2.quit();
    }

    @Test
    public void windowTest2() {
        bookLoginPage = new BookLoginPage(driver);
        bookLoginPage.loginToBookStore();
        profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.logOutButton.isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://demoqa.com/login','_blank');");
        originalWindow = bookLoginPage.getOriginalWindow();
        bookLoginPage.switchToNewTab(originalWindow);
        Assert.assertEquals(bookLoginPage.getInfoText(), "You are already logged in. View your profile.");

        System.out.println("jkdjdjdjd");
    }
}
