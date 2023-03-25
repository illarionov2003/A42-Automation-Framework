import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void successfulLoginTest() {
        login("demo@class.com", "te$t$tudent");
        WebElement avatar = driver.findElement(By.cssSelector("a .avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        login("demo@class.com", "te$t$tuden");
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        login("demo@class.com", "");
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

}
