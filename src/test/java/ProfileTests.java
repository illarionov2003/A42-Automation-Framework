import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    public void changeProfileNameTest() {
        PageFactory.initElements(getDriver(), loginPage);
        loginPage.login("demo@class.com", "te$t$tudent");
        profilePage.openProfile();
        profilePage.enterCurrentPassword("te$t$tudent");
        profilePage.enterCurrentEmail("demo@class.com");
        String newName = profilePage.generateRandomName();
        System.out.println(newName);
        profilePage.enterNewName(newName);
        profilePage.saveProfile();
        basePage.getDriver().navigate().refresh();
        String name = profilePage.getProfileName();
        Assert.assertEquals(newName, name);
    }



}
