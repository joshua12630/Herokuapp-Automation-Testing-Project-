package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class FormPage {
    WebDriver driver;
    String Test = " Hello From FormPage Constructor";

public FormPage(WebDriver driver){
    this.driver = driver;
    System.out.println(Test);
}
    By userNameBy = By.id("username");
    By passwordBy = By.id("password");
    By loginButtonBy = By.xpath("//button[@class=\"radius\"]");
    By actualFailedMessageBy = By.id("flash");
    String expectedFailureMessageTextForUserName = "Your username is invalid!";
    String expectedFailureMessageTextForPassword = "Your password is invalid!";

    public void  enterUsername(String username){
        driver.findElement(userNameBy).sendKeys(username);
    }
    public void  enterPassword(String password){
        driver.findElement(passwordBy).sendKeys(password);
    }
    public SecureArea  clickLoginButton(){
        driver.findElement(loginButtonBy).click();
        return new SecureArea(driver);
    }

    private String getActualFailedMessage(){
        return driver.findElement(actualFailedMessageBy).getText();
    }

    public boolean isLoginFailedCaseUsername(){

        return getActualFailedMessage().contains(expectedFailureMessageTextForUserName);

    }

    public boolean isLoginFailedCasePassword(){

        return getActualFailedMessage().contains(expectedFailureMessageTextForPassword);

    }


}
