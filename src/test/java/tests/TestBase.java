package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    String urlBank = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    String urlGlobalSqa = "https://www.globalsqa.com/samplepagetest/";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(urlGlobalSqa);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
