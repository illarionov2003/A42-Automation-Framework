import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import pages.BasePage;

public class BaseTest {
    protected final BasePage basePage = new BasePage();
    public String url = "https://bbb.testpro.io/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        basePage.initBrowser(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        basePage.closeBrowser();
    }

    @DataProvider (name="IncorrectLoginProviders")
    public static Object [][] getDataFromDataProviders(){
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