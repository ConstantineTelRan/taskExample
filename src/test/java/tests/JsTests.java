package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.demoqa.TablePage;
import pages.demoqa.TextBox;

public class JsTests extends TestBase{


    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String permanentAddress = faker.address().fullAddress();
    TextBox textBox;



    @Test
    public void fillTest() {
        driver.get("https://demoqa.com/text-box");
        textBox = new TextBox(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('userName').value='Victor';");
        js.executeScript("document.getElementById('userEmail').value='Victor@gmail.com';");
        js.executeScript("document.getElementById('currentAddress').value='Current Address';");
        js.executeScript("document.getElementById('permanentAddress').value='Permanent Address';");
        js.executeScript("arguments[0].click();", textBox.getSaveButton());
//        js.executeScript("document.getElementById('submit').click();");
        System.out.println("ieieiie");

    }

    @Test
    public void fillTest2() {
        driver.get("https://demoqa.com/text-box");
        textBox = new TextBox(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("document.getElementById('userName').value='%s';", name));
        js.executeScript(String.format("document.getElementById('userEmail').value='%s';", email));
        js.executeScript(String.format("document.getElementById('currentAddress').value='%s';", currentAddress));
        js.executeScript("document.getElementById('permanentAddress').value='%s';",permanentAddress);
        js.executeScript("document.getElementById('submit').click();");
        System.out.println("ieieiie");

    }

    @Test
    public void scrollToElement() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement x = driver.findElement(By.xpath("//span[@id=\"Wikipedia_languages\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", x);
        System.out.println("ieieiie");

    }

    @Test
    public void getPageText() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text =  js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(text);
    }

    @Test
    public void getTitle() {
        driver.get("https://demoqa.com/text-box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text =  js.executeScript("return document.title;").toString();
        System.out.println(text);
    }

    @Test
    public void getDomain() {
        driver.get("https://demoqa.com/text-box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text =  js.executeScript("return document.domain;").toString();
        System.out.println(text);
    }

    @Test
    public void getUrl() {
        driver.get("https://demoqa.com/text-box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text =  js.executeScript("return document.URL;").toString();
        System.out.println(text);
    }

    @Test
    public void nav() {
        driver.get("https://demoqa.com/text-box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location = 'https://en.wikipedia.org/wiki/Main_Page'");
        System.out.println("jsjsjs");
    }


    @Test
    public void check() {
        driver.get("https://demoqa.com/checkbox");
        textBox = new TextBox(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('tree-node-home').checked=true;");

        js.executeScript("document.getElementById('tree-node-home').checked=false;");
        System.out.println("jsjsjs");
    }




}
