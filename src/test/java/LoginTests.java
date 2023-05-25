
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "IncorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void negativeLoginTests(String email, String password) {
        PageFactory.initElements(basePage.getDriver(), loginPage);
        loginPage.login(email, password);

        Assert.assertEquals(basePage.getDriver().getCurrentUrl(), url);
    }

    @Test
    public void successfulLoginTest() {
        PageFactory.initElements(basePage.getDriver(), loginPage);
        loginPage
                .enterEmail("demo@class.com")
                .enterPassword("te$t$tudent")
                .clickLoginButton();
        Assert.assertTrue(basePage.getAvatar().isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        PageFactory.initElements(basePage.getDriver(), loginPage);
        loginPage.login("demo@class.com", "te$t$tuden");
        Assert.assertTrue(loginPage.getSubmitLoginButton().isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        PageFactory.initElements(basePage.getDriver(), loginPage);
        loginPage.login("demo@class.com", "");
        Assert.assertTrue(loginPage.getSubmitLoginButton().isDisplayed());
    }
}