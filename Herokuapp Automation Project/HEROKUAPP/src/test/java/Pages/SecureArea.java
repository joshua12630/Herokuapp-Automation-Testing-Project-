package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureArea {
    WebDriver driver;

    public SecureArea(WebDriver driver){
        this.driver = driver;
    }

    By logoutButtonBy = By.xpath("//i[@class='fa fa-sign-out']");
    //WebElement logoutButton = driver.findElement(By.xpath("//i[@class='fa fa-sign-out']"));
   // String successMessage = driver.findElement(By.id("flash")).getText();
    By successMessageBy = By.id("flash");
    String expectedSuccessMessageText = "You logged into a secure area!";

    public void clickLogoutButton(){
        driver.findElement(logoutButtonBy).click();
    }

    public String getActualMessage(){
        return driver.findElement(successMessageBy).getText();
    }
    public String getExpectedSuccessMessage(){
        return expectedSuccessMessageText;
    }


    public boolean isLoggedIn(){
        return  getActualMessage().contains(expectedSuccessMessageText);
    }



}
