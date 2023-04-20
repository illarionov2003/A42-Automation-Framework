package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.time.Duration;

public class LoginStepDefinition extends BasePage {
    WebDriver driver;
    public String url = "https://bbb.testpro.io/";
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @Before
    public void openBrowser() throws MalformedURLException {
        initBrowser(url);
    }

    @After
    public void exitBrowser() {
        closeBrowser();
    }


    @When("I enter email {string}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);

    }

    @And("I enter password {string}")
    public void EnterPassword(String password) {
       loginPage.enterPassword(password);
        
    }

    @And("I submit")
    public void Submit() {
        loginPage.clickLoginButton();
        
    }

    @Then("I am logged in")
    public void AmLoggedIn() {
        Assert.assertTrue(basePage.getAvatar().isDisplayed());
    }
}



