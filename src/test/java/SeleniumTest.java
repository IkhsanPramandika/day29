import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {

    @Test
public void test001 () {

        System.setProperty("webdriver.gecko.diver", System.getProperty("user.dir")+"/driver/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        // Kalo banyak file/variabel disarankan ini , agar bisa kepanggil dibanyak file
        WebElement usernameTextField = driver.findElement((By.xpath("//*[@id=\"user-name\"]")));
        usernameTextField.sendKeys("standard_user");

        //kalo dikit dibawah ini
        //        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standar_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        WebElement product = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        Assert.assertTrue(product.isDisplayed(),"Element gagal muncul");
        driver.quit();

    }










}
