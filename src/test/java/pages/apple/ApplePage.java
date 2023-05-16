package pages.apple;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplePage {
    WebDriver driver;

    public ApplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name=\"s\"]")
    private WebElement searchInput;

    public void fillSearch(String text) throws InterruptedException {
        searchInput.click();
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void fillWithJs() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementsByName('s').value='Apple';");
        searchInput.sendKeys(Keys.ENTER);
    }
}
