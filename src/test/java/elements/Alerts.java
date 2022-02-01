package elements;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.UsefulMethods;

import java.util.TreeMap;

import static utilities.UsefulMethods.*;

public class Alerts {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void seeAlert() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");

        WebElement _alert = driver.findElement(By.xpath("//*[@id='alertButton']"));
        highlightElement(_alert);
        _alert.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("You clicked a button", alertText);
        alert.accept();

    }

    @Test
    public void timerAlert() {
        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void confirmButton() {
        driver.navigate().to("https://demoqa.com/alerts");

        WebElement button = driver.findElement(By.xpath("//*[@id='confirmButton']"));
        button.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement confirmElement = driver.findElement(By.xpath("//*[@id='confirmResult']"));
        Assert.assertEquals("You selected Cancel", confirmElement.getText());


    }

    @Test
    public void prompt() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");
        String text = "Selenium";

        driver.findElement(By.xpath("//*[@id='promtButton']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        Thread.sleep(3000);

        alert.accept();
        String result = driver.findElement(By.xpath("//*[@id='promptResult']")).getText();
        Assert.assertEquals("You entered " + text, result);

    }


}



















