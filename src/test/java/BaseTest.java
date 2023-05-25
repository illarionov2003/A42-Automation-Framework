
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.BasePage;

import java.net.MalformedURLException;

public class BaseTest extends BasePage{
    protected final BasePage basePage = new BasePage();
    public String url = "https://bbb.testpro.io/";


    @BeforeMethod
    public void setUpBrowser() throws MalformedURLException {
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