package pages.demoqa.window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends CommonWindow {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id=\"tabButton\"]")
    private WebElement newTabButton;
    @FindBy(xpath = "//div[@class=\"main-header\"]")
    private WebElement mainHeader;

    public void clickToNewTabButton() {
        newTabButton.click();
    }

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

    public boolean isMainHeader() {
        return mainHeader.isDisplayed();
    }

}
