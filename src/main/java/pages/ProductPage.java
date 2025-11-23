package pages;

import org.openqa.selenium.WebDriver; // Import WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage extends BasePage {

    public ProductPage (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    private WebElement swagLabLogo;

    public void verifySwagLabLogoIsDisplayed(){
        Assert.assertTrue(swagLabLogo.isDisplayed(), "Swag Lab logo is not displayed");
    }
}