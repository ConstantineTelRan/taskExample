package pages.demoqa.window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabWindow extends CommonWindows {
    WebDriver driver;

    public TabWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@id=\"sampleHeading\"]")
    private WebElement sampleHeading;

    public String getText() {
        return sampleHeading.getText();
    }

}
