import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.List;

public class SongsTests extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void addSongToPlaylist()  {

        String song = "Waiting on a train";

        loginPage.login("demo@class.com", "te$t$tudent");

        WebElement searchField = basePage.getDriver().findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);

        WebElement viewAllBtn = basePage.getDriver().findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllBtn.click();

        List<WebElement> songResults = basePage.getDriver().findElements(By.cssSelector("#songResultsWrapper .song-item"));
        songResults.get(0).click();

        WebElement addToBtn = basePage.getDriver().findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();

        List<WebElement> listNameField = basePage.getDriver().findElements(By.cssSelector(".form-save [data-test='new-playlist-name']"));
        listNameField.get(2).click();
        listNameField.get(2).clear();
        listNameField.get(2).sendKeys("123");
        new Actions(basePage.getDriver())
                .keyDown(Keys.ENTER)
                .perform();

        WebElement successBanner = basePage.getDriver().findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(successBanner.isDisplayed());
    }
}


