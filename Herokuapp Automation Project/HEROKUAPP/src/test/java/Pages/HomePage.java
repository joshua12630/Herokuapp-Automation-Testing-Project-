package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class HomePage {

    WebDriver driver;

    By formLinkBy = By.linkText("Form Authentication");
    By checkoxlocator = By.linkText("Checkboxes");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public FormPage goToFormPage(){
        driver.findElement(formLinkBy).click();
        return new FormPage(driver);
    }

public DynamicLoading gotodynamicloadingpage(){
  driver.findElement(By.linkText("Dynamic Loading")).click();
return new DynamicLoading(driver);
}


}



