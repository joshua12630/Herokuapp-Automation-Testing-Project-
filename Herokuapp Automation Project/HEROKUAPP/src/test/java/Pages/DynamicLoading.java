package Pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoading {

        WebDriver driver;

        public DynamicLoading(WebDriver driver) {
            this.driver = driver;
        }

By elementonpagethatishidden1 = By.linkText("Example 1: Element on page that is hidden");
By elementonthepagethatishidden2=By.linkText("Example 2: Element rendered after the fact");
By clickstartbutton1 = By.xpath("//*[@id='start']/button");
By Clickstartbutton2=By.xpath("//*[@id='start']/button");
public void clickonelementone(){
    driver.findElement(elementonpagethatishidden1).click();

}

public void clickonelementtwo(){

    driver.findElement(elementonthepagethatishidden2).click();

}
public void Clickstartbutton1(){
    driver.findElement(clickstartbutton1).click();

}

public void setGetClickstartbutton2(){


    driver.findElement(Clickstartbutton2).click();
}
    }








