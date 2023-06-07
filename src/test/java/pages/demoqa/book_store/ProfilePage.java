package pages.demoqa.book_store;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    WebDriver driver;

    @FindBy(xpath = "//button[normalize-space()=\"Log out\"]")
    public WebElement logOutButton;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickToBookStoreLink() {
        driver.findElement(By.xpath("//button[@id=\"gotoStore\"]"))
                .click();
    }

    public void clickToLogOutButton() {
        logOutButton.click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById('submit').click()");
    }


}
