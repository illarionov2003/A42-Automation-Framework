import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SongsTests extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        String song = "Waiting on a train";
        // login
        login("demo@class.com", "te$t$tudent");
        // search song
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);
        // click view all
        WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        // click on the first song
        List<WebElement> songResults = driver.findElements(By.cssSelector("#songResultsWrapper .song-item"));
        songResults.get(0).click();
        // add to playlist
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
        // create a new playlist
        List<WebElement> listNameField = driver.findElements(By.cssSelector(".form-save [data-test='new-playlist-name']"));
        listNameField.get(2).click();
        listNameField.get(2).clear();
        listNameField.get(2).sendKeys("123");
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        // assert
        WebElement successBanner = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(successBanner.isDisplayed());
    }

    @Test
    public void playSong() {
        // login
        login("demo@class.com", "te$t$tudent");
        // hover
        WebElement playControlPanel = driver.findElement(By.cssSelector(".player-controls"));
        new Actions(driver)
                .moveToElement(playControlPanel)
                .perform();
        // start song
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playBtn.click();
        // assert
        WebElement pauseBtn = driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
    }


}
