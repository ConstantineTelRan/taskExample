package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.demoqa.book_store.api.session.ApiLogin;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Map;

public class TestBase {
    protected WebDriver driver;
    protected Faker faker = new Faker();
    String urlBank = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    String urlGlobalSqa = "https://www.globalsqa.com/samplepagetest/";

    @BeforeMethod
    public void setUp() {
//        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new SafariDriver();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
//        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ApiLogin apiLogin = new ApiLogin();
        Map<String, String> cook = apiLogin.getSession();
        driver.manage().addCookie(new Cookie("token", cook.get("token")));
        driver.get("https://demoqa.com/books");


//        driver.get(urlGlobalSqa);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
