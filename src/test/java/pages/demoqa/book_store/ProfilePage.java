package pages.demoqa.book_store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickToBookStoreLink() {
        driver.findElement(By.xpath("//button[@id=\"gotoStore\"]"))
                .click();
    }
}
