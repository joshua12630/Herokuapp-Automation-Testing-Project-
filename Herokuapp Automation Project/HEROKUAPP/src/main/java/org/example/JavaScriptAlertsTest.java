package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptAlertsTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts"); // update path
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void testJsAlert() {
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[contains(text(),'JS Alert')]"));
        jsAlertButton.click();

        // Wait for alert and switch
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert", "Alert text mismatch");
        alert.accept();

        // Verify result text
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(result.contains("You successfully clicked an alert"), "Result text incorrect");
    }

    @Test(priority = 2)
    public void testJsConfirm() {
        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
        jsConfirmButton.click();

        Alert confirm = driver.switchTo().alert();
        Assert.assertEquals(confirm.getText(), "I am a JS Confirm", "Confirm text mismatch");
        confirm.dismiss(); // or confirm.accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(result.contains("You clicked: Cancel"), "Confirm result incorrect");
    }

    @Test(priority = 3)
    public void testJsPrompt() {
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[contains(text(),'JS Prompt')]"));
        jsPromptButton.click();

        Alert prompt = driver.switchTo().alert();
        Assert.assertEquals(prompt.getText(), "I am a JS prompt", "Prompt text mismatch");

        // Send text into prompt
        prompt.sendKeys("Quantum Tester");
        prompt.accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(result.contains("Quantum Tester"), "Prompt input not reflected in result");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
