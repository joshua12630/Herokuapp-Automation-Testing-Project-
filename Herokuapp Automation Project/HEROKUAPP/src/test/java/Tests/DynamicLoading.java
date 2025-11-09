package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoading {
    WebDriver driver;
    By startButtonLocator = By.xpath("//div/button");
    By loadingTextLocator = By.id("loading");
    By finishTextLocator = By.xpath("//div[@id='finish']/h4");
    String expectedText = "Hello World!";
    WebDriverWait wait;

    public void dynamicloadingtest(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }

    public void ClickOnStartButton(){

wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(startButtonLocator))).click();


    }



    public boolean LoadingIndicatorIsDisplayed(){

        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(loadingTextLocator))).isDisplayed();



    }

    private String Getactualfinishtext(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(finishTextLocator))).getText();


    }

    public boolean expectedmessageisdisplayed(){

return Getactualfinishtext()

    }
}
