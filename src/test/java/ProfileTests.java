import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProfileTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    public void changeProfileNameTest() throws InterruptedException {
        loginPage.login("demo@class.com", "te$t$tudent");
        profilePage.openProfile();
        profilePage.enterCurrentPassword("te$t$tudent");
        profilePage.enterCurrentEmail("demo@class.com");
        String newName = profilePage.generateRandomName();
        System.out.println(newName);
        profilePage.enterNewName(newName);
        profilePage.saveProfile();
        basePage.getDriver().navigate().refresh();

        WebElement profileName = profilePage.getProfileName();

        WebDriverWait w = new WebDriverWait(basePage.getDriver(), Duration.ofSeconds(30));
        w.until(ExpectedConditions.textToBe(By.cssSelector("span.name"), newName));

        System.out.println(profileName.getText());
        Assert.assertEquals(newName, profileName.getText());
    }
}
