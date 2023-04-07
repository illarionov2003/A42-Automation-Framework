import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlaylist extends BaseTest {
    @Test
    public void renamePlayList() throws InterruptedException {
        login("oleksandr.illarionov@testpro.io", "te$t$tudent");
        doubleClickChoosePlayList();
        enterPlayListName("SUPER");
        getPlayListName();
    }

    public void doubleClickChoosePlayList() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/ul//a[@href='#!/playlist/52425']")));
        actions.doubleClick().perform();
    }
    public void enterPlayListName (String name) throws InterruptedException {
        Thread.sleep(5000);
        WebElement playListInputField = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        playListInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,"SUPER",Keys.END),name);
        playListInputField.sendKeys(Keys.ENTER);
    }
    private String getPlayListName(){
        WebElement playlistElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/ul//a[@href='#!/playlist/52425']")));
        String name = playlistElement.getText();
        return name;
    }
}
