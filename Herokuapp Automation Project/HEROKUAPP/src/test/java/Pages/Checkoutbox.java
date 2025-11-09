package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Checkoutbox {

    public static void main (String[] args){

        WebDriver driver;
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Checkboxes")).click();
        driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();









    }
}
