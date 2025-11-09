package Tests;
import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    public void loginWithValidCredentials(){
         formPage = homePage.goToFormPage();
         formPage.enterUsername("tomsmith");
         formPage.enterPassword("SuperSecretPassword!");
         secureArea = formPage.clickLoginButton();
         Assert.assertTrue(secureArea.isLoggedIn());
//         Assert.assertEquals(secureArea.getActualMessage(), secureArea.getExpectedSuccessMessage());
//         Assert.assertTrue(secureArea.getActualMessage().contains(secureArea.getExpectedSuccessMessage()));
    }
    @Test(priority = 2)
    public void loginWithInvalidCredentials(){
        formPage = homePage.goToFormPage();
        formPage.enterUsername("");
        formPage.enterPassword("");
        secureArea = formPage.clickLoginButton();
        Assert.assertFalse(secureArea.isLoggedIn());
    }

    @Test(priority = 3)
    public void loginWithInvalidUsername(){
        formPage = homePage.goToFormPage();
        formPage.enterUsername("");
        formPage.enterPassword("SuperSecretPassword!");
        formPage.clickLoginButton();
        Assert.assertTrue(formPage.isLoginFailedCaseUsername());

    }
@Test(priority = 4)
    public void loginWithInvalidPassword(){
        formPage = homePage.goToFormPage();
        formPage.enterUsername("tomsmith");
        formPage.enterPassword("!");
        secureArea = formPage.clickLoginButton();
        Assert.assertTrue(formPage.isLoginFailedCasePassword());

    }
}
