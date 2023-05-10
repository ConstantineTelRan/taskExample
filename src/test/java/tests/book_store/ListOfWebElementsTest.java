package tests.book_store;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.book_store.BookLoginPage;
import pages.demoqa.book_store.BookStore;
import pages.demoqa.book_store.ProfilePage;
import tests.TestBase;

import java.util.List;

public class ListOfWebElementsTest extends TestBase {
    BookLoginPage bookLoginPage;
    BookStore bookStore;
    ProfilePage profilePage;

    String url = "https://demoqa.com/login";
    List<WebElement> bookTitle;
    List<String> bookTitleTexts;

    @BeforeMethod
    public void precondition() {
        driver.get(url);

    }

    @Test
    public void listOfWebElementsTest() {
        bookLoginPage = new BookLoginPage(driver);
        bookLoginPage.loginToBookStore();
        profilePage = new ProfilePage(driver);
        profilePage.clickToBookStoreLink();
        bookStore = new BookStore(driver);
        bookTitle = bookStore.getBookTitles();
        bookTitleTexts = bookStore.getBookTitlesTexts();
        WebElement el = bookStore.getElement("You Don't Know JS");
        String text = el.getText();
        System.out.println("djjd");

    }
}
