import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import static java.sql.DriverManager.getDriver;

public class ProfileTests extends BaseTest {
    LoginPage loginPage = new LoginPage(basePage.getDriver());
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
        Thread.sleep(1000);
        String name = profilePage.getProfileName();
        Assert.assertEquals(newName, name);
    }
}
