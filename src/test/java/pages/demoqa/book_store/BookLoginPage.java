package pages.demoqa.book_store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookLoginPage {
    WebDriver driver;

    public BookLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='userName']")
    WebElement userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//div[@class='text-right button'][1]")
    WebElement loginButton;

    public void loginToBookStore() {
        userNameInput.clear();
        userNameInput.sendKeys("admin");
        passwordInput.clear();
        passwordInput.sendKeys("Qwerty@12345");
        loginButton.click();
    }
}
