package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @Test
    public void scaleBrowser() {
        driver.get("https://demoqa.com/text-box");
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.COMMAND)
//                .sendKeys("-").keyUp(Keys.COMMAND).perform();
//        actions.keyDown(Keys.COMMAND)
//                .sendKeys("-").keyUp(Keys.COMMAND).perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");
        js.executeScript("document.body.style.zoom='150%'");

        System.out.println("jdjdjdjd");
    }

    @Test
    public void getPageText() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(pageText);
        Assert.assertTrue(pageText.contains("Welcome to Wikipedia"));
        Assert.assertTrue(pageText.contains("a continuous spectrum of colours, it is traditionally assigned a"));
    }

    @Test
    public void getTitle() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        Assert.assertEquals(title, "Wikipedia, the free encyclopedia");
        System.out.println(title);
    }

    @Test
    public void getDomain() {
        driver.get("https://demoqa.com/text-box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String domain = js.executeScript("return document.domain").toString();
        Assert.assertEquals(domain, "demoqa.com");
        System.out.println(domain);

    }

    @Test
    public void getURL() {
        driver.get("https://demoqa.com/text-box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = js.executeScript("return document.URL").toString();
        System.out.println(url);
        Assert.assertEquals(url, "https://demoqa.com/text-box");
    }

    @Test
    public void nav() {
        driver.get("https://demoqa.com/text-box");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location = 'https://en.wikipedia.org/wiki/Main_Page'");
        System.out.println("kjdksksk");
    }

    @Test
    public void checkbox() {
        driver.get("https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true");
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=false");
        System.out.println();

    }

    @Test
    public void checkbox2() {
        driver.get("https://demoqa.com/checkbox");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('tree-node-home').click()");
        js.executeScript("document.getElementById('tree-node-home').click()");
        System.out.println();
    }

    @Test
    public void checkbox3() {
        driver.get("https://demoqa.com/checkbox");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//input[@id=\"tree-node-home\"]"));
        js.executeScript("arguments[0].click", element);
        js.executeScript("arguments[0].click", element);
        System.out.println();
    }


    @Test
    public void dropDown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));

        String selectOptionScript = "arguments[0].selectedIndex = INDEX; arguments[0].dispatchEvent(new Event('change'));";
        int optionIndex = 1; // Индекс выбранного элемента (нумерация начинается с 0)

        js.executeScript(selectOptionScript.replace("INDEX", String.valueOf(optionIndex)), dropdownElement);

        System.out.println("kdkdkd");
    }


}
