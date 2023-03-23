import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends BaseTest {
    @Test
    public void RegistrationTest () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        //registration
        WebElement Registration = driver.findElement(By.xpath("//a[@id='hel']"));
        Registration.click();
        //email
        WebElement InputEmail = driver.findElement(By.xpath("//input[@type='email']"));
        InputEmail.click();
        InputEmail.clear();
        InputEmail.sendKeys("oleksandr.illarionov@testpro.io");
        //button
        WebElement InputButton = driver.findElement(By.xpath("//input[@type='submit']"));
        InputButton.click();

        String RegistrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(),RegistrationUrl);
        driver.quit();

    }
}
