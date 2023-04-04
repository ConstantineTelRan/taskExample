package pages.demoqa.window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Set;

public class Windows extends CommonWindows {
    WebDriver driver;

    public Windows(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id=\"tabButton\"]")
    private WebElement tabButton;

    @FindBy(xpath = "//button[@id=\"windowButton\"]")
    private WebElement windowButton;

    @FindBy(xpath = "//button[@id=\"messageWindowButton\"]")
    private WebElement messageWindowButton;

    @FindBy(xpath = "//div[@class=\"main-header\"]")
    private WebElement mainHeader;


    public void clickToTabButton() {
        tabButton.click();
    }

    public void clickToWindowButton() {
        windowButton.click();
    }

    public void clickToMessageWindowButton() {
        messageWindowButton.click();
    }

    public String getMainTitle() {
        return mainHeader.getText();
    }







}
