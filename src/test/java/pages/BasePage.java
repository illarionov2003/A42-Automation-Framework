package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BasePage {
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    static WebDriver driver;
    WebDriverWait wait;

    //
    public static WebDriver getThreadLocal() {

        return THREAD_LOCAL.get();
    }

//    public void initBrowser(String url) throws MalformedURLException {
//        SafariOptions options = new SafariOptions();
////        options.addArguments("--disable-notifications");
////        options.addArguments("--remote-allow-origins=*");
//        driver = pickBrowser(System.getProperty("browser"));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//        driver.manage().window().maximize();
//        driver.get(url);
    //}
public void initBrowser(@Optional String url) throws MalformedURLException {
    THREAD_LOCAL.set(pickBrowser("browser"));
    THREAD_LOCAL.get().manage().window().maximize();
    THREAD_LOCAL.get().manage().deleteAllCookies();
    THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    getThreadLocal().get(url);
    System.out.println(
            "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

}
    public static void closeBrowser() {
        // driver.quit();
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }

//    public WebDriver waitUntilVisible(By element) {
//        return (WebDriver) wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//    }
public WebElement waitUntilVisible(By element){
    return new WebDriverWait(THREAD_LOCAL.get(), Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(element));
}

//    public WebDriver waitUntilClickable(By element) {
//        return (WebDriver) wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
public WebElement waitUntilClickable(By element){
    return new WebDriverWait(THREAD_LOCAL.get(), Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
}

//    public WebDriver getDriver() {
//        return driver;
//    }
    public WebDriver getDriver(){
        return THREAD_LOCAL.get();
    }
    public WebElement getAvatar() {
        return getDriver().findElement(By.cssSelector("a .avatar"));
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.0.90:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
//              case "cloud":

            default: // changed lambda to default, so it's not using existing chrome
                return lambdaTest();
//            default:
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--disable-notifications");
//                options.addArguments("--remote-allow-origins=*");
//                return driver = new ChromeDriver(options);
        }
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "illarionov2003";
        String authkey = "BY11Q4NmjU6cUm10269CbXnJVtx2lt6WMBng46lW232dYuuVkh";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Firefox");
        caps.setCapability("version", "103.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

}

