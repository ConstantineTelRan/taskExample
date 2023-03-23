package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoqa.ProgressBar;

public class ProgressBarTest extends TestBase{
    String url = "https://demoqa.com/progress-bar";
    String percent = "50";
    String percentRandom = Integer.toString(faker.number().numberBetween(10,  99));

    ProgressBar progressBar;
    String progressBarValue;


    @BeforeMethod
    public void precondition() {
        driver.get(url);
    }

    @Test
    public void progressBarTest() {
        progressBar = new ProgressBar(driver);
        progressBar.startStopClickToStartStopButton();
        progressBar.stopClickToStartStopButton(percentRandom);
//        progressBarValue = ;
        Assert.assertEquals(progressBar.getAttributeValue(), percentRandom);
        System.out.println(percentRandom);
    }
}
