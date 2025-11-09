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
import java.util.List;

public class AddRemoveElementsWaitTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/path/to/your/add_remove.html"); // update path

        // Initialize WebDriverWait (10 seconds timeout)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAddAndRemoveElements() {
        By addButtonLocator = By.xpath("//button[contains(text(),'Add Element')]");
        By deleteButtonsLocator = By.xpath("//div[@id='elements']/button");

        // Wait until the Add Element button is visible
        WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addButtonLocator));

        // Count existing Delete buttons
        List<WebElement> initialDeleteButtons = driver.findElements(deleteButtonsLocator);
        int initialCount = initialDeleteButtons.size();

        // Click Add Element button
        addButton.click();

        // Wait until number of delete buttons increases by 1
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(deleteButtonsLocator, initialCount));

        // Verify element was added
        int afterAddCount = driver.findElements(deleteButtonsLocator).size();
        Assert.assertEquals(afterAddCount, initialCount + 1, "New element should be added!");

        // Delete one element
        WebElement firstDeleteButton = driver.findElement(By.xpath("(//div[@id='elements']/button)[1]"));
        firstDeleteButton.click();

        // Wait until number of delete buttons decreases by 1
        wait.until(ExpectedConditions.numberOfElementsToBe(deleteButtonsLocator, afterAddCount - 1));

        // Verify deletion
        int afterDeleteCount = driver.findElements(deleteButtonsLocator).size();
        Assert.assertEquals(afterDeleteCount, afterAddCount - 1, "One element should be removed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

