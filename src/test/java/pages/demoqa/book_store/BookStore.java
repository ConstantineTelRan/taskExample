package pages.demoqa.book_store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    public List<WebElement> getElements() {
        return driver.findElements(By.xpath("//span[@class='mr-2']//a"));
    }

    public List<String> getElementsText() {
        return getElements().stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public void clickToElement(String text) {
         getElements().stream().filter(webelement -> Objects.equals(webelement.getText(), text))
                .findFirst()
                .orElseThrow().click();
    }



}
