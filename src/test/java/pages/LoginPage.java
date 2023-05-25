package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final By submitBtn = By.cssSelector("button[type='submit']");
    By passwordField = By.cssSelector("[type ='password']");
    By emailField = By.xpath("//input[@type='email']");

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public LoginPage enterPassword(String password) {
        WebElement passwordInput = getDriver().findElement(passwordField);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage enterEmail(String email) {
        WebElement emailInput = getDriver().findElement(emailField);
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage clickLoginButton() {
        WebElement submitButton = getDriver().findElement(submitBtn);
        submitButton.click();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable (submitButton));
        return this;
    }

    public WebElement getSubmitLoginButton() {
        return getDriver().findElement(submitBtn);
    }

}

