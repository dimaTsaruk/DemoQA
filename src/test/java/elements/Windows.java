package elements;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.Set;

public class Windows {
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
    public void windowSwitch() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/browser-windows");
        String currentWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id='tabButton']")).click();

        Set<String> allOpenWindowHandles = driver.getWindowHandles();
        for (String window : allOpenWindowHandles) {
            if (!window.equals(currentWindowHandle)) {
                driver.switchTo().window(window);
            }
        }
        Thread.sleep(3000);
        WebElement newWinHeader = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        String header = newWinHeader.getText();
        String text = "This is a sample page";
        Assert.assertEquals(text, header);

        driver.switchTo().window(currentWindowHandle);
        WebElement button = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(button.isDisplayed());


    }


}










