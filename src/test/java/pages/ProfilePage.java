package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.UUID;

public class ProfilePage extends BasePage{


    public String getProfileName() {
        WebElement profileName = getDriver().findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }

    public void saveProfile() {
        WebElement saveButton = getDriver().findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
    }

    public void enterNewName(String newName) {
        WebElement userNameField = getDriver().findElement(By.id("inputProfileName"));
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(newName);
    }

    public void enterCurrentEmail(String email) {
        WebElement currentEmailField = getDriver().findElement(By.id("inputProfileEmail"));
        currentEmailField.click();
        currentEmailField.clear();
        currentEmailField.sendKeys(email);
    }

    public void enterCurrentPassword(String password) {
        WebElement currentPasswordField = getDriver().findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    public void openProfile() {
        WebElement profile =getDriver().findElement(By.cssSelector(".view-profile"));
        profile.click();
    }

    public String generateRandomName() {

        return UUID.randomUUID().toString().replace("-", "");
    }
}
