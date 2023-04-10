package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    //LOCATORS
    By passwordField = By.cssSelector("[type='password']");
    By emailField =  By.xpath("//input[@type='email']");
    By submitBtn = By.cssSelector("button[type='submit']");
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    protected void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailField);
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    protected void clickLoginButton() {
        WebElement submitLoginButton = driver.findElement(submitBtn);
        submitLoginButton.click();
    }
}
