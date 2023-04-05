
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ActionsTests extends BaseTest {


    @Test
    public void playSongTest() {
        // hover over in clickPlayBtn
        login("demo@class.com", "te$t$tudent");
        clickPlayBtn();
        Assert.assertTrue(pauseBtnExists());

        // Comparing numbers of elements example
        List<WebElement> songs = driver.findElements(By.cssSelector("[data-test='song-card']"));

        int songsNumberBefore = songs.size();
        System.out.println(songsNumberBefore);
        // Just an example: here we would add or delete an element but we didn't
        int songsNumberAfter = songs.size();
        System.out.println(songsNumberAfter);

        // Soft assert example
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/#!/queue");
        softAssert.assertTrue(songsNumberBefore == songsNumberAfter,
                "=== Songs number before should be equal songs number after ===");
        softAssert.assertAll();
    }

    @Test
    public void renamePlaylist() {
        // double click
        String playlistName = "Summer songs";

        login("demo@class.com", "te$t$tudent");
        doubleClickChoosePlaylist();
        enterPlaylistName(playlistName);
        String newName = getPlaylistName();
        Assert.assertEquals(playlistName, newName);
    }

    @Test
    public void playSongFromListTest() throws InterruptedException {
        // right click
        login("demo@class.com", "te$t$tudent");
        goToAllSongs();
        WebElement firstSong = driver.findElement(By.cssSelector(".song-item"));
        Actions actions = new Actions(driver);
        actions.contextClick(firstSong).perform();
        WebElement playBtn = driver.findElement(By.cssSelector(".playback"));
        playBtn.click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
    }

    public void clickPlayBtn() {
        Actions action = new Actions(driver);
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        action
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }

    public boolean pauseBtnExists() {
        return driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
    }


    private void goToAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".songs"))).click();
    }


    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    private String getPlaylistName() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        String name = playlistElement.getText();
        return name;
    }

    @Test
    public void countSongsInPlaylist() {

        login("demo@class.com", "te$t$tudent");
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        playlist.click();
        List<WebElement> songs = driver.findElements(By.cssSelector("#playlistWrapper .song-item"));
        int number = songs.size();
        Assert.assertEquals(number, 4); // can fail, depends on current number. This is just an example
        
    }

}
