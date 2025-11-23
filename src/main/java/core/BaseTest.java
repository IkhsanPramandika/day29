package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp () {
        DrivenManager.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DrivenManager.quitDriver();
    }
}