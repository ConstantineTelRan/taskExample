package pages.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBar {
    WebDriver driver;

    public ProgressBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role=\"progressbar\"]")
    private WebElement progressBar;

    @FindBy(xpath = "//button[@id=\"startStopButton\"]")
    private WebElement startStopButton;

    private final String ATTRIBUTE_NAME = "aria-valuenow";

    public void clickToStartStopButton() {
        startStopButton.click();
    }

     public String getAttributeValue() {
        return  progressBar.getAttribute(ATTRIBUTE_NAME);
     }

     public void waitePercentExplicit(String percent) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.attributeToBe(progressBar, ATTRIBUTE_NAME, percent));
     }

     public void waitePercentFluent(String percent) {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofNanos(2000000))
                .until(ExpectedConditions.attributeToBe(progressBar, ATTRIBUTE_NAME, percent));

     }
     public void clickToStop(String percent) {
//        waitePercentExplicit(percent);
        waitePercentFluent(percent);
        clickToStartStopButton();
     }








}
