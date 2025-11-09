package BaseTest;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected HomePage homePage;
    protected  WebDriver driver;
    protected FormPage formPage;
    protected SecureArea secureArea;
    protected AddRemovePage AddRemovePage;
    protected DynamicLoading dynamicLoading;
    WebDriverWait wait;


    @BeforeClass
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goToFormPage(){
        driver.get("https://the-internet.herokuapp.com/");
    }




}
public void jawjaw(){




}