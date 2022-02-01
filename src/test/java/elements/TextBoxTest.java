package elements;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;


public class TextBoxTest {
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
    public void test1() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/text-box");
        Actions actions = new Actions(driver);

        WebElement fullNameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        fullNameInput.sendKeys("Dima");
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        actions.click(submitButton).perform();

////        WebDriverWait wait = new WebDriverWait(driver, 5);
////        WebElement submit =
////                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='name']")));
//        Thread.sleep(3000);
//       // WebElement submitText = driver.findElement(By.xpath("//p[@class='mb-1']"));
//        WebElement submitText = driver.findElement(By.xpath("//*[@id='output']/div/p"));
//       // Assert.assertTrue(submitText.getText().contains("Dima"));


    }

    @Test
    public void buttons() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);

        WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickMe).perform();
        WebElement clickText = driver.findElement(By.id("dynamicClickMessage"));
        String clickMeMessage = "You have done a dynamic click";
        Assert.assertEquals(clickMeMessage, clickText.getText());
        Thread.sleep(2000);

        WebElement rightClickMe = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickMe).perform();
        WebElement rcMessageElement = driver.findElement(By.id("rightClickMessage"));
        String rcMessage = "You have done a right click";
        Assert.assertEquals(rcMessage, rcMessageElement.getText());
        Thread.sleep(2000);


        WebElement doubleClickMe = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickMe).perform();
        WebElement doubleClickMessageElement = driver.findElement(By.id("doubleClickMessage"));
        String dcMessage = "You have done a double click";
        Assert.assertEquals(dcMessage, doubleClickMessageElement.getText());


    }

    @Test
    public void radioButton() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/radio-button");
        Actions actions = new Actions(driver);

        //driver.findElement(By.id("yesRadio")).click();
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        actions.click(yesRadio).perform();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='text-success']")));

        // Thread.sleep(3000);
        Assert.assertTrue(yesRadio.isSelected());
        WebElement yes = driver.findElement(By.xpath("//*[@class='text-success']"));
        Assert.assertTrue(yes.isDisplayed());

        WebElement disabledRadio = driver.findElement(By.xpath("//*[@id='noRadio']"));
        Assert.assertFalse(disabledRadio.isEnabled());


    }


}









