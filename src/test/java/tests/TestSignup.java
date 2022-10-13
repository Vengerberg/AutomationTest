package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestSignup extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        loginPage = new LoginPage(driver, actions, wait);
        signupPage = new SignupPage(driver, actions, wait);
        accountCreatedPage = new AccountCreatedPage(driver, actions, wait);
    }

    @Test(groups = {"signup"})
    public void TestRegisterUser() {
        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.signup(firstName + " " + lastName, email);
        wait.until(ExpectedConditions.urlToBe(baseURL + signupPage.getRoute()));

        Assert.assertEquals(driver.getCurrentUrl(), baseURL + signupPage.getRoute());
        Assert.assertEquals(signupPage.getName(), firstName + " " + lastName);
        Assert.assertEquals(signupPage.getEmail(), email);

        signupPage.signup(firstName, lastName, password,
                birthDay, birthMonth, birthYear,
                address, country, state, city, zip,
                phone);
        wait.until(ExpectedConditions.urlToBe(baseURL + accountCreatedPage.getRoute()));

        Assert.assertEquals(driver.getCurrentUrl(), baseURL + accountCreatedPage.getRoute());
        Assert.assertTrue(accountCreatedPage.accountCreatedMessageVisible());

        accountCreatedPage.clickContinueButton();
        wait.until(ExpectedConditions.urlToBe(baseURL));

        Assert.assertEquals(driver.getCurrentUrl(), baseURL);

        homePage.clickLogout();
    }

    @Test(dependsOnGroups = {"signup"})
    public void TestAlreadyRegisteredUser() {
        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.signup(firstName + " " + lastName, email);

        Assert.assertEquals(driver.getCurrentUrl(), baseURL + signupPage.getRoute());
        Assert.assertTrue(signupPage.emailAlreadyExistsIsVisible());
    }

    @Test(dependsOnGroups = {"delete"})
    public void TestRegisterDeletedUser() {

    }
}

