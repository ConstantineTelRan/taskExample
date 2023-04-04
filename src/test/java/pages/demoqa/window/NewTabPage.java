package pages.demoqa.window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTabPage extends  CommonWindow{
    public NewTabPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@id=\"sampleHeading\"]")
    private WebElement header;

    public String getHeaderText() {
        return header.getText();
    }

}
