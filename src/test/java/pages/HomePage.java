package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    By searchField = By.cssSelector("[type='search']");
    By viewAllButton = By.cssSelector("[data-test='view-all-songs-btn']");

    By successNotification = By.cssSelector(".success.show");
    By searchResults = By.cssSelector("#songResultsWrapper .song-item");
    By avatarIcon = By.cssSelector("a .avatar");

    public void search(String text) {
        WebElement searchInput =
                waitUntilVisible(searchField);
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    public void viewAllSearchResults() {
        WebElement viewAllBtn = waitUntilVisible(viewAllButton);
        viewAllBtn.click();
    }

    public void clickFirstSearchResult() {
        List<WebElement> songResults = driver.findElements(searchResults);
        songResults.get(0).click();
    }

    public WebElement getSuccessBanner(){
        return waitUntilVisible(successNotification);
    }

    public WebElement getAvatar(){
        return waitUntilVisible(avatarIcon);
    }
}
