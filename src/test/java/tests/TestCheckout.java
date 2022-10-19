package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class TestCheckout extends BaseTest {

    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        cartPage = new CartPage(driver, actions, wait);
        checkoutPage = new CheckoutPage(driver, actions, wait);
        loginPage = new LoginPage(driver, actions, wait);
    }

    @Test
    public void testCheckoutWithEmptyCart() {
        homePage.clickViewCart();
        wait.until(ExpectedConditions.urlToBe(baseURL + cartPage.getRoute()));

        Assert.assertTrue(cartPage.getCartSize() == 0, "Cart should be empty when checking out without adding products");
    }

    @Test(dataProvider = "random-product-provider")
    public void testCheckoutNotLoggedIn(String productName) {
        SoftAssert softAssert = new SoftAssert();
        homePage.addProduct(productName);
        homePage.clickViewCartFromPopup();
        wait.until(ExpectedConditions.urlToBe(baseURL + cartPage.getRoute()));

        cartPage.proceedToCheckout();

        softAssert.assertTrue(cartPage.registerOrLoginPopupVisible(), "Signup or login popup should display if user checks out with logging in");

        cartPage.continueOnCartFromPopup();
        cartPage.emptyCart();

        softAssert.assertAll();
    }

    @Test(dependsOnGroups = {"signup"}, groups = {"logged-in"}, dataProvider = "random-product-provider")
    public void testCheckoutLoggedIn(String productName) {
        SoftAssert softAssert = new SoftAssert();

        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.login(email, password);

        homePage.addProduct(productName);
        homePage.clickViewCartFromPopup();
        wait.until(ExpectedConditions.urlToBe(baseURL + cartPage.getRoute()));

        cartPage.proceedToCheckout();
        wait.until(ExpectedConditions.urlToBe(baseURL + checkoutPage.getRoute()));

        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + checkoutPage.getRoute(), "URL should be redirected to home page URL after logging in");

        driver.navigate().to(baseURL);
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        homePage.clickLogout();
        softAssert.assertAll();
    }

    @Test(dependsOnGroups = {"signup"}, groups = {"logged-in"}, dataProvider = "multi-product-provider")
    public void testCorrectDetailsDisplayed(String... products) {
        SoftAssert softAssert = new SoftAssert();

        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.login(email, password);

        for(String productName: products) {
            homePage.addProduct(productName);
            homePage.clickContinueShopping();
        }

        homePage.clickViewCart();

        wait.until(ExpectedConditions.urlToBe(baseURL + cartPage.getRoute()));

        cartPage.proceedToCheckout();
        wait.until(ExpectedConditions.urlToBe(baseURL + checkoutPage.getRoute()));

        softAssert.assertTrue(checkoutPage.addressIsDisplayedCorrectly(title, firstName, lastName, address, country, state, city, zip, phone), "Delivery details should display correct customer details matching signup info");
        softAssert.assertTrue(checkoutPage.invoiceIsDisplayedCorrectly(title, firstName, lastName, address, country, state, city, zip, phone), "Invoice details should display correct customer details matching signup info");
        softAssert.assertTrue(checkoutPage.productPricesDisplayedCorrectly(), "Prices should be equal to sum of product costs in cart");

        driver.navigate().to(baseURL);
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        homePage.clickLogout();
        softAssert.assertAll();
    }

    @AfterMethod
    public void clearCarts() {
        driver.navigate().to(baseURL + cartPage.getRoute());
        cartPage.emptyCart();
    }
}
