import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistsPage;
import pages.SongsPage;

import java.util.ArrayList;
import java.util.List;

public class SongsTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    PlaylistsPage playlistsPage = new PlaylistsPage();
    SongsPage songsPage = new SongsPage();

    @Test
    public void addSongToPlaylist() {

        String song = "Waiting on a train";
        PageFactory.initElements(getDriver(), loginPage);
        // login
        loginPage.login("demo@class.com", "te$t$tudent");
        // search song
        homePage.search(song);
        // click view all
        homePage.viewAllSearchResults();
        // click on the first song
        homePage.clickFirstSearchResult();
        // click add to playlist
        playlistsPage.addSongToPlaylist();
        // create a new playlist
        playlistsPage.createNewPlaylistWhileAddingSong("123");
        Assert.assertTrue(homePage.getSuccessBanner().isDisplayed());
    }

    @Test
    public void playSong() {
        PageFactory.initElements(getDriver(), loginPage);
        // login
        loginPage.login("demo@class.com", "te$t$tudent");
        // hover
        songsPage.hoverOverPlayControl();
        // start song
        songsPage.playSong();
        // assert
        Assert.assertTrue(songsPage.getPauseButton().isDisplayed());
    }

    @Test
    public void addPlaylist() throws InterruptedException {
        PageFactory.initElements(getDriver(), loginPage);
        loginPage.login("demo@class.com", "te$t$tudent");
        String plName = "Rock stars 2";
        playlistsPage.createPlaylist(plName);
        Thread.sleep(2000);
        List<String> playlistNames = playlistsPage.getPlaylistNames();
        System.out.println(playlistNames);
        Assert.assertTrue(playlistNames.contains(plName));
    }



}
