import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();


    @Test
    public void successfulLoginTest() {

        PageFactory.initElements(basePage.getDriver(), loginPage);
        loginPage.enterEmail("demo@class.com").enterPassword("te$t$tudent").clickLoginButton();
        //loginPage.login("demo@class.com", "te$t$tudent");
        //WebElement avatar = basePage.getDriver().findElement(By.cssSelector("a .avatar"));
        Assert.assertTrue(basePage.getAvatar().isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        PageFactory.initElements(basePage.getDriver(), loginPage);
        loginPage.login("demo@class.com", "te$t$tuden");
        //WebElement submitLoginButton = basePage.getDriver().findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(loginPage.getSubmitLoginButton().isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        PageFactory.initElements(basePage.getDriver(), loginPage);
        loginPage.login("demo@class.com", "");
        WebElement submitLoginButton = basePage.getDriver().findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }
}