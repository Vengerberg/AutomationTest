package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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

    @Test(dependsOnGroups = {"signup"}, groups = {"logged-in"})
    public void testLogout() {
        SoftAssert softAssert = new SoftAssert();

        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.login(email, password);

        homePage.clickLogout();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + loginPage.getRoute(), "URL should be redirected to login page URL after logging out");

        loginPage.clickHomeButton();
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        softAssert.assertFalse(homePage.logoutIsVisible(), "After logging out, logout button should not be visible");
        softAssert.assertFalse(homePage.deleteAccountIsVisible(), "After logging out, delete account button should not be visible");
        softAssert.assertAll();
    }
}
