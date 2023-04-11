package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SongsPage extends BasePage {
   By playControlPanel = By.cssSelector(".player-controls");
   By playSongBtn = By.cssSelector("[data-testid='play-btn']");
   By pauseBtn = By.cssSelector("[data-testid='pause-btn']");

   By songs = By.cssSelector("[data-test='song-card']");

   public void hoverOverPlayControl() {
       new Actions(driver)
               .moveToElement(waitUntilVisible(playControlPanel))
               .perform();
   }


   public  void playSong() {
       WebElement playBtn = waitUntilVisible(playSongBtn);
       playBtn.click();
   }

    public WebElement getPauseButton(){
        return waitUntilVisible(pauseBtn);
    }

    public List<WebElement> getSongs() {
       return driver.findElements(By.cssSelector("[data-test='song-card']"));
    }

    public WebElement getSoundBar(){
        return waitUntilVisible(By.cssSelector("[data-testid='sound-bar-play']"));
    }

    public void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector(".playback"));
        playBtn.click();
    }

    public void clickFirstSong() {
        WebElement firstSong = driver.findElement(By.cssSelector(".song-item"));
        Actions actions = new Actions(driver);
        actions.contextClick(firstSong).perform();
    }


}
