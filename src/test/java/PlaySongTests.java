import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTests extends BaseTest {
    @Test
    public void playSong(){
        //login
        login("oleksandr.illarionov@testpro.io", "te$t$tudent");

        WebElement playControlPanel = driver.findElement(By.cssSelector(".player-controls"));
        playControlPanel.click();


        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playBtn.click();


        WebElement pauseBtn = driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());

    }
}
