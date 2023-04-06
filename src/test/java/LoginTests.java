import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(dataProvider = "IncorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void negativeLoginTests(String email, String password) throws InterruptedException {
        loginPage.login(email, password);
        Thread.sleep(5000);
        Assert.assertEquals(basePage.getDriver().getCurrentUrl(), url);
    }


    @Test
    public void successfulLoginTest() {
        loginPage.login("demo@class.com", "te$t$tudent");
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        loginPage.login("demo@class.com", "te$t$tuden");
        Assert.assertTrue(loginPage.getSubmitLoginButton().isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        loginPage.login("demo@class.com", "");
        Assert.assertTrue(loginPage.getSubmitLoginButton().isDisplayed());
    }



}
