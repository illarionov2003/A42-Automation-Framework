package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PlaylistsPage extends BasePage {

    By forthPlaylist = By.cssSelector(".playlist:nth-child(3)");

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


    public void goToAllSongs() {
        waitUntilClickable(By.cssSelector(".songs")).click();
    }


    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = waitUntilClickable(forthPlaylist);
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getPlaylistName() {
        WebElement playlistElement = waitUntilVisible(forthPlaylist);
        String name = playlistElement.getText();
        return name;
    }

}
