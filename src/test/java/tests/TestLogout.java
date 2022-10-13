package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestLogout extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        loginPage = new LoginPage(driver, actions, wait);
    }

    @Test
    public void testLogout() {
    }
}
