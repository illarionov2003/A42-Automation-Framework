import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.BasePage;

import java.net.MalformedURLException;

public class BaseTest extends BasePage {

    protected final BasePage basePage = new BasePage();
    public String url = "https://bbb.testpro.io/";


//    @BeforeSuite
//    static void setupClass() {
//        WebDriverManager.safaridriver().setup();
//    }

    @BeforeMethod
    public void setUpBrowser() throws MalformedURLException {
        basePage.initBrowser(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        basePage.closeBrowser();
    }


    @DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }

    public BasePage getBasePage() {
        return basePage;
    }

}