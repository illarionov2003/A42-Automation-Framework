package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public static LoginPage loginPage() {
        return new LoginPage();
    }

    //LOCATORS
    @FindBy(css = "[type='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;
    @FindBy(css = "button[type='submit']")
    WebElement submitLoginBtn;
    private final By submitBtn = By.cssSelector("button[type='submit']");
    //By passwordField = By.cssSelector("[type ='password']");
    //By emailField =  By.xpath("//input[@type='email']");
    // By submitBtn = By.cssSelector("button[type='submit']");
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    public LoginPage enterPassword(String password) {
        //WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }
    public LoginPage enterEmail(String email) {
        // WebElement emailInput = driver.findElement(emailField);
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }
    public LoginPage clickLoginButton() {
        // WebElement submitLoginButton = driver.findElement(submitBtn);
        submitLoginBtn.click();
        return this;
    }
    public WebElement getSubmitLoginButton() {
        return clickLoginButton().submitLoginBtn;
    }
}




