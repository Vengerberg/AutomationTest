package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;

public class TestLogin extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        loginPage = new LoginPage(driver, actions, wait);
    }

    @Test
    public void testLoginWithInvalidAccount() {
        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.login(faker.bothify("########??@gmail.com"), faker.bothify("##?#?#???####"));
        Assert.assertTrue(loginPage.invalidLoginIsVisible(), "User should be displayed a message when logging in with invalid credentials");
    }

    @Test(dependsOnGroups = {"signup"}, groups = {"logged-in"})
    public void testLoginWithValidAccount() {
        SoftAssert softAssert = new SoftAssert();

        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.login(email, password);
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + "/");
        softAssert.assertTrue(homePage.logoutIsVisible(), "User should see logout button after logging in");
        softAssert.assertTrue(homePage.deleteAccountIsVisible(), "User should see delete account button after logging in");

        driver.navigate().to(baseURL);
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        homePage.clickLogout();
        softAssert.assertAll();
    }
}
