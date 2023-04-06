package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PlaylistsPage extends BasePage {

    public void addSongToPlaylist(){
        WebElement addToBtn = waitUntilVisible(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void createNewPlaylistWhileAddingSong(String playlistName){
        List<WebElement> listNameField = driver.findElements(By.cssSelector(".form-save [data-test='new-playlist-name']"));
        listNameField.get(2).click();
        listNameField.get(2).clear();
        listNameField.get(2).sendKeys(playlistName);
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }

}
