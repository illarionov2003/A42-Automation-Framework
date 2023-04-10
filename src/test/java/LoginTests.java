import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    @Test
    public void successfulLoginTest() {
        loginPage.login("demo@class.com", "te$t$tudent");
        WebElement avatar = basePage.getDriver().findElement (By.cssSelector("a .avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        loginPage.login("demo@class.com", "te$t$tuden");
        WebElement submitLoginButton = basePage.getDriver().findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        loginPage.login("demo@class.com", "");
        WebElement submitLoginButton = basePage.getDriver().findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

}
