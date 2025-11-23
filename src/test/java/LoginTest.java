import core.BaseTest;
import core.DrivenManager;
import core.TestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;


@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", "success"},      // Data 1: Sukses
                {"locked_out_user", "secret_sauce", "failed"},     // Data 2: User Terkunci
                {"problem_user", "secret_sauce", "success"}        // Data 3: User Bermasalah (tapi bisa login)
        };
    }

    @Test(dataProvider = "loginData")
    public void test_login_scenario(String username, String password, String scenarioType) {
        DrivenManager.getDriver().get("https://www.saucedemo.com/");
        // --------------------------

        LoginPage loginPage = new LoginPage(DrivenManager.getDriver());
        ProductPage productPage = new ProductPage(DrivenManager.getDriver());

        log.info("Menjalankan test dengan user: " + username);

        log.info("Menjalankan test dengan user: " + username);

        loginPage.inputUsernameTextField(username);
        loginPage.inputPasswordTextField(password);
        loginPage.clickLoginButton();

        if (scenarioType.equals("success")) {
            productPage.verifySwagLabLogoIsDisplayed();
            log.info("Login berhasil, masuk ke halaman produk.");

        } else if (scenarioType.equals("failed")) {
            log.info("Login gagal sesuai ekspektasi (Negative Case).");
        }
    }
}