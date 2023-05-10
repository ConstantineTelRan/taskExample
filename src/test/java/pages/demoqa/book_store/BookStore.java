package pages.demoqa.book_store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BookStore {
    WebDriver driver;

    public BookStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getBookTitles() {
        return driver.findElements(By.xpath("//span[@class='mr-2']//a"));

    }

    public List<String> getBookTitlesTexts() {
        return getBookTitles().stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public WebElement getElement(String text) {
        return getBookTitles().stream().filter(webElement -> Objects.equals(webElement.getText(), text))
                .findFirst()
                .orElseThrow();
    }


}
