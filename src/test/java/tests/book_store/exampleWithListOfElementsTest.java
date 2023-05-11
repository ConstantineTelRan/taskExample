package tests.book_store;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.book_store.BookLoginPage;
import pages.demoqa.book_store.BookStore;
import pages.demoqa.book_store.ProfilePage;
import tests.TestBase;

import java.util.List;

public class exampleWithListOfElementsTest extends TestBase {
    BookLoginPage bookLoginPage;
    ProfilePage profilePage;
    BookStore bookStore;

    List<WebElement> elements;
    List<String> bookTitles;

    String url = "https://demoqa.com/login";

    @BeforeMethod
    public void open() {
        driver.get(url);
    }

    @Test
    public void exampleTest() {
        bookLoginPage = new BookLoginPage(driver);
        bookLoginPage.loginToBookStore();
        profilePage = new ProfilePage(driver);
        profilePage.clickToBookStoreLink();
        bookStore = new BookStore(driver);
        elements = bookStore.getElements();
        bookTitles = bookStore.getElementsText();
        bookStore.clickToElement("Designing Evolvable Web APIs with ASP.NET");
        System.out.println("jdjdjdejjd");
    }
}
