package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DrivenManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void initDriver(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/driver/geckodriver.exe");
        driver.set(new FirefoxDriver());
        driver.get().get("https://www.saucedemo.com/");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
