import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

public class ProfileTests extends BaseTest {

    @Test
    public void successfulLoginTest() {
        login("demo@class.com", "te$t$tudent");
        openProfile();
        enterCurrentPassword("te$t$tudent");
        enterCurrentEmail("demo@class.com");
        String newName = generateRandomName();
        System.out.println(newName);
        enterNewName(newName);
        saveProfile();
        driver.navigate().refresh();
        String name = getProfileName();
        Assert.assertEquals(newName, name);
    }

    private String getProfileName() {
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }

    private void saveProfile() {
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
    }

    private void enterNewName(String newName) {
        WebElement userNameField = driver.findElement(By.id("inputProfileName"));
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(newName);
    }

    private void enterCurrentEmail(String email) {
        WebElement currentEmailField = driver.findElement(By.id("inputProfileEmail"));
        currentEmailField.click();
        currentEmailField.clear();
        currentEmailField.sendKeys(email);
    }

    private void enterCurrentPassword(String password) {
        WebElement currentPasswordField = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    private void openProfile() {
        WebElement profile = driver.findElement(By.cssSelector(".view-profile"));
        profile.click();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
