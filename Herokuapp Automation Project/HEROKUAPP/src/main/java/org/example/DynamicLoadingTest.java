package org.example;

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

public class DynamicLoadingTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Load your local or hosted HTML file
        driver.get("file:///C:/path/to/your/dynamic_loading.html"); // <-- update path

        // Create explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testDynamicLoading() {
        By startButtonLocator = By.xpath("//div[@id='start']/button");
        By loadingLocator = By.id("loading");
        By finishLocator = By.id("finish");

        // Wait for the Start button to be clickable
        WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(startButtonLocator));

        // Click Start
        startButton.click();

        // Wait until loading message appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingLocator));

        // Wait until loading message disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingLocator));

        // Wait until “Hello World!” is visible
        WebElement helloText = wait.until(ExpectedConditions.visibilityOfElementLocated(finishLocator));

        // Verify text
        String actualText = helloText.getText().trim();
        Assert.assertEquals(actualText, "Hello World!", "Dynamic content did not load correctly!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

