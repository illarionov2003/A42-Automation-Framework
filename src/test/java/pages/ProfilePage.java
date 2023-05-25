package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class ProfilePage extends BasePage{

    @FindBy(css = "span.name")
    private  WebElement profileName;

    @FindBy(css = ".btn-submit")
    private  WebElement saveButton;

    @FindBy(id = "inputProfileName")
    private WebElement userNameField;

    @FindBy(id = "inputProfileEmail")
    private  WebElement currentEmailField;

    @FindBy(id = "inputProfileCurrentPassword")
    private  WebElement currentPasswordField;

    @FindBy(css = ".view-profile")
    private WebElement profile;


    public WebElement getProfileName() {
       PageFactory.initElements(getDriver(), this);

        return profileName;
    }

    public void saveProfile() {
        PageFactory.initElements(getDriver(), this);
        saveButton.click();
    }

    public void enterNewName(String newName) {
        PageFactory.initElements(getDriver(), this);

        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(newName);
    }

    public void enterCurrentEmail(String email) {
        PageFactory.initElements(getDriver(), this);

        currentEmailField.click();
        currentEmailField.clear();
        currentEmailField.sendKeys(email);
    }

    public void enterCurrentPassword(String password) {
        PageFactory.initElements(getDriver(), this);

        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    public void openProfile() {
        PageFactory.initElements(getDriver(), this);

        profile.click();
    }

    public String generateRandomName() {

        return UUID.randomUUID().toString().replace("-", "");
    }
}
