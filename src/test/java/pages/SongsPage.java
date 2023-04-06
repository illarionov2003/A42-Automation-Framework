package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SongsPage extends BasePage {
   By playControlPanel = By.cssSelector(".player-controls");
   By playSongBtn = By.cssSelector("[data-testid='play-btn']");
   By pauseBtn = By.cssSelector("[data-testid='pause-btn']");

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
}
