package pages.demoqa.window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class CommonWindows {

    String originalWindow; //2 этап
    WebDriver driver;

    public CommonWindows(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void switchToTab() {
        originalWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void closeAndSwitchToOriginalWindow() {
        driver.close();
        driver.switchTo().window(originalWindow); //2 этап
    }
}
