package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DeletePage;
import pages.HomePage;
import pages.LoginPage;

public class TestDeleteAccount extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private DeletePage deletePage;


    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        loginPage = new LoginPage(driver, actions, wait);
        deletePage = new DeletePage(driver, actions, wait);
    }

    @Test(groups = {"delete"}, dependsOnGroups = {"signup", "logged-in"})
    public void testDeleteAccount() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.login(email, password);
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        homePage.clickDeleteAccountButton();
        wait.until(ExpectedConditions.urlToBe(baseURL + deletePage.getRoute()));

        softAssert.assertTrue(deletePage.accountDeletedHeaderDisplayed());
        softAssert.assertTrue(deletePage.accountDeletedMessageDisplayed());

        driver.navigate().to(baseURL);
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        softAssert.assertFalse(homePage.logoutIsVisible());
        softAssert.assertFalse(homePage.deleteAccountIsVisible());
        softAssert.assertAll();
    }
}
