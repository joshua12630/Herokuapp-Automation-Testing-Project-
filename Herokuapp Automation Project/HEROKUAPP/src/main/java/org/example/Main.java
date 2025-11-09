package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
/*        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);  // Add this line


        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();*/


       /* TestCons obj = new TestCons();*/


/*

            WebDriver driver;


                // Setup ChromeDriver (ensure chromedriver is in PATH)
                driver = new ChromeDriver();
                driver.manage().window().maximize();

                // Load HTML directly or via URL
                driver.get("https://the-internet.herokuapp.com/checkboxes"); // replace with your file or URL



                // Locate checkbox by label text “checkbox 1”
                WebElement checkbox1 = driver.findElement(By.xpath(
                        "//input[normalize-space(following-sibling::text()[1])='checkbox 1']"
                ));

                // Click checkbox
                checkbox1.click();

                // Verify it is selected
                Assert.assertTrue(checkbox1.isSelected(), "Checkbox 1 should be selected after clicking");

                // Click again to unselect
                checkbox1.click();

                // Verify it is now unselected
                Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 should be unselected after clicking again");



                driver.quit();

*/


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Checkboxes")).click();
        driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();





    }
}