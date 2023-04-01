import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlaylistTests extends BaseTest{
    @Test
    public void deletePlaylist(){
        login("oleksandr.illarionov@testpro.io", "te$t$tudent");

        WebElement playList = driver.findElement(By.cssSelector("section#playlists > ul > li:nth-of-type(3)"));
        playList.click();

        WebElement buttonDelete= driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        buttonDelete.click();

        WebElement successBanner = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(successBanner.isDisplayed());
    }
}
