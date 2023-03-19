package tests.demoqa;

import com.github.javafaker.Faker;
import demoqa.TextBox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class DemoQaTest extends TestBase {
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String permanentAddress = faker.address().fullAddress();

    String url = "https://demoqa.com/text-box";
    TextBox textBox;

    @BeforeMethod
    public void precondition() {
        driver.get(url);
    }

    @Test
    public void boxTest() {
        textBox = new TextBox(driver);
        textBox.fillTextBox(name, email, currentAddress, permanentAddress);
        textBox.waitText();

        Assert.assertEquals(textBox.getTextFromInfoField("name"), "Name:" + name);
        Assert.assertEquals(textBox.getTextFromInfoField("email"), "Email:" + email);

    }
}
