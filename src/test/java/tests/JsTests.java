package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoqa.TextBox;

public class JsTests extends TestBase {
    TextBox textBox;
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();

    @Test
    public void fillTest() {
        driver.get("https://demoqa.com/text-box");
        textBox = new TextBox(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('userName').value='Victor'");
        js.executeScript("document.getElementById('userEmail').value='email@gmail.com'");
        js.executeScript("document.getElementById('currentAddress').value='currentAddress'");
        js.executeScript("document.getElementById('permanentAddress').value='permanentAddress'");
        js.executeScript("document.getElementById('submit').click()");

        String actualName = js.executeScript("return arguments[0].innerText", textBox.getElement("name")).toString();

        Assert.assertEquals(actualName, "Name:Victor");
        System.out.println("jdjdjdjd");
    }

    @Test
    public void fillTest2() {
        driver.get("https://demoqa.com/text-box");
        textBox = new TextBox(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("document.getElementById('userName').value='%s'", name));
        js.executeScript(String.format("document.getElementById('userEmail').value='%s'", email));

        System.out.println("jdjdjjjd");
    }

    @Test
    public void scrollToElement() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement wikipediaLanguagesTitle = driver.findElement(By.xpath("//span[normalize-space()=\"Other areas of Wikipedia\"]"));
        js.executeScript("arguments[0].scrollIntoView(true)", wikipediaLanguagesTitle);

        System.out.println("jdjdjjjd");
    }


}
