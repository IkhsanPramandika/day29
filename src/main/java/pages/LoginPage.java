package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement usernameTextField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordTextField;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    // Tambahan Element Error Message (PENTING untuk Data Driven Negative Test)
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public void verifyUsernameTextFieldIsDisplayed(){
        Assert.assertTrue(usernameTextField.isDisplayed(), "Username TextField is not displayed");
    }

    // --- PERBAIKAN DI SINI ---
    // Tambahkan (String username) di dalam kurung
    public void inputUsernameTextField(String username){
        // Ubah isi sendKeys menjadi variabel, BUKAN teks "standard_user"
        usernameTextField.sendKeys(username);
    }

    public void verifyPasswordTextFieldIsDisplayed(){
        Assert.assertTrue(passwordTextField.isDisplayed(), "Password TextField is not displayed");
    }

    // --- PERBAIKAN DI SINI ---
    // Tambahkan (String password) di dalam kurung
    public void inputPasswordTextField(String password){
        // Ubah isi sendKeys menjadi variabel
        passwordTextField.sendKeys(password);
    }

    public void verifyLoginButtonIsDisplayed(){
        Assert.assertTrue(loginButton.isDisplayed(), "Login Button is not displayed");
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void verifyErrorMessage(String expectedMessage){
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message tidak muncul");
        Assert.assertTrue(errorMessage.getText().contains(expectedMessage), "Pesan error tidak sesuai");
    }

}