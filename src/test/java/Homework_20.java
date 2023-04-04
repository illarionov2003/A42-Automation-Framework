import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_20 extends BaseTest {
    @Test
    public void successfulLoginTest() {
        login("demo@class.com", "te$t$tudent");
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a .avatar")));
        Assert.assertTrue(avatar.isDisplayed());

    }

    @Test
    public void wrongPasswordLoginTest() {
        login("demo@class.com", "te$t$tuden");
        WebElement submitLoginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        login("demo@class.com", "");
        WebElement submitLoginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

}
