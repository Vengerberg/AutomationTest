package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
        SoftAssert softAssert = new SoftAssert();

        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.signup(firstName + " " + lastName, email);
        wait.until(ExpectedConditions.urlToBe(baseURL + signupPage.getRoute()));

        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + signupPage.getRoute(), "URL should redirect to signup page URL after clicking signup");
        softAssert.assertEquals(signupPage.getName(), firstName + " " + lastName, "Name should match entered name from login signup form");
        softAssert.assertEquals(signupPage.getEmail(), email, "Email should match entered email from login signup form");

        signupPage.signup(firstName, lastName, title, password,
                birthDay, birthMonth, birthYear,
                address, country, state, city, zip,
                phone);
        wait.until(ExpectedConditions.urlToBe(baseURL + accountCreatedPage.getRoute()));

        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + accountCreatedPage.getRoute(), "URL should redirect to account created page URL after signing up");
        softAssert.assertTrue(accountCreatedPage.accountCreatedMessageVisible(), "Account created message should display after signing up");

        accountCreatedPage.clickContinueButton();
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + "/", "URL should redirect to home page after clicking continue from account created page");

        driver.navigate().to(baseURL);
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        homePage.clickLogout();
        softAssert.assertAll();
    }

    @Test(dependsOnGroups = {"signup"}, groups = {"logged-in"})
    public void TestAlreadyRegisteredUser() {
        SoftAssert softAssert = new SoftAssert();

        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.signup(firstName + " " + lastName, email);

        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + signupPage.getRoute(), "URL should redirect to signup page URL");
        softAssert.assertTrue(signupPage.emailAlreadyExistsIsVisible(), "Email already exists message should display when registering with already registered email");
        softAssert.assertAll();
    }
}
