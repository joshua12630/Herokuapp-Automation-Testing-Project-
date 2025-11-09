package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemovePage {
    WebDriver driver;
    By AddButtonLocator =By.xpath("//button[@oneclick='addElement()']");
    By DeleteButtonLocator = By.xpath("//button[contains(text(),'delete')]");
    public  AddRemovePage(WebDriver driver){
        this.driver= driver;

    }
    public void ClickOnAddButton(int times){
        for (int i =0 ; i<= times ; i++){

driver.findElement(AddButtonLocator).click();
        }


    }
    public void ClickDelete(int times){
        List<WebElement> deletebuttons= driver.findElements(DeleteButtonLocator);
        int NumberOfButtons = deletebuttons.size();
        if (times<=NumberOfButtons){
            for (int i = 0 ; i< times; i++){
                deletebuttons.get(i).click();



            }






        }else System.out.println("out of bound your target is " +times+"but button number is "+NumberOfButtons);






    }
   public int GetNumberOfDeleteButtons(){

      List<WebElement>deletebuttons = driver.findElements(DeleteButtonLocator);
      return  deletebuttons.size();










   }















}
