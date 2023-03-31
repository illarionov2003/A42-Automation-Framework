import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongToPlayListTests extends BaseTest {
    @Test
    public void addSong() {
        login("oleksandr.illarionov@testpro.io", "te$t$tudent");

        WebElement SearchField= driver.findElement(By.cssSelector("[type='search']"));
        SearchField.click();
        SearchField.clear();
        SearchField.sendKeys("Dark days");

        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();

        WebElement FirstSongButton = driver.findElement(By.cssSelector("#songResultsWrapper .items > tr:nth-of-type(1) > .title"));
        FirstSongButton.click();

        WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButton.click();

        WebElement listNameField= driver.findElement(By.cssSelector("#songResultsWrapper [required]"));
        listNameField.click();
        listNameField.clear();
        listNameField.sendKeys("123");
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();

        WebElement successBanner = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(successBanner.isDisplayed());

    }
}