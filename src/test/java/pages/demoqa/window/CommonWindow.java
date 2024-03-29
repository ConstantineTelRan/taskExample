package pages.demoqa.window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class CommonWindow {
    WebDriver driver;

    public CommonWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getOriginalWindow() {
        return driver.getWindowHandle();
    }

    public void switchToNewTab(String originalWindow) {
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles) {
            if(!originalWindow.equals(handle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void closeAndSwitchToOriginalWindow(String originalWindow) {
        driver.close();
        driver.switchTo().window(originalWindow);
    }
}
