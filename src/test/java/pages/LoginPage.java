package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super();
    }

    public static LoginPage loginPage(){
        return new LoginPage(driver);
    }

    //LOCATORS
//    @FindBy(css = "[type='password']")
//    WebElement passwordInput;
//    @FindBy(xpath = "//input[@type='email']")
//    WebElement emailInput;

    //@FindBy(css = "button[type='submit']")
    //WebElement submitLoginBtn;

    private final By submitBtn = By.cssSelector("button[type='submit']");
    By passwordField = By.cssSelector("[type ='password']");
    By emailField =  By.xpath("//input[@type='email']");
    //By submitBtn = By.cssSelector("button[type='submit']");
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
        //WebElement emailInput = driver.findElement(emailField);
        WebElement emailInput = getDriver().findElement(emailField);
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }
//    public LoginPage clickLoginButton() {
//        WebElement submitButton = getDriver().findElement(submitBtn);
//        submitButton.click();
//        return this;
//    }
//
//    public WebElement getSubmitLoginButton() {
//        return getDriver().findElement(submitBtn);
//    }
public LoginPage clickLoginButton() {
    WebElement submitButton = getDriver().findElement(submitBtn);
    submitButton.click();
    return this;
}

    public WebElement getSubmitLoginButton() {
        return getDriver().findElement(submitBtn);
    }


}

