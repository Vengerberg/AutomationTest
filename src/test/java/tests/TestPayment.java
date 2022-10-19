package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;


public class TestPayment extends BaseTest {

    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;
    private PaymentDonePage paymentDonePage;
    private LoginPage loginPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        cartPage = new CartPage(driver, actions, wait);
        checkoutPage = new CheckoutPage(driver, actions, wait);
        paymentPage = new PaymentPage(driver, actions, wait);
        paymentDonePage = new PaymentDonePage(driver, actions, wait);
        loginPage = new LoginPage(driver, actions, wait);
    }

    @Test(dependsOnGroups = {"signup"}, groups = {"logged-in"}, dataProvider = "multi-product-provider")
    public void testPayForCart(String... products) {
        SoftAssert softAssert = new SoftAssert();

        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(baseURL + loginPage.getRoute()));

        loginPage.login(email, password);
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        for(String productName: products) {
            homePage.addProduct(productName);
            homePage.clickContinueShopping();
        }

        homePage.clickViewCart();

        wait.until(ExpectedConditions.urlToBe(baseURL + cartPage.getRoute()));

        cartPage.proceedToCheckout();
        wait.until(ExpectedConditions.urlToBe(baseURL + checkoutPage.getRoute()));

        String cartTotal = checkoutPage.getCartTotal();

        checkoutPage.clickPlaceOrderButton();
        wait.until(ExpectedConditions.urlToBe(baseURL + paymentPage.getRoute()));

        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + paymentPage.getRoute(), "URL should redirect to payment page URL after placing order");

        paymentPage.placeOrder(firstName + " " + lastName, creditCard, cvc, expirationMonth, expirationYear);

        wait.until(ExpectedConditions.urlToBe(baseURL + paymentDonePage.getRoute(cartTotal)));
        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + paymentDonePage.getRoute(cartTotal), "URL should redirect to payment done page URL after submitting order");
        softAssert.assertTrue(paymentDonePage.orderPlacedMessageIsVisible(), "Order placed message should be displayed after submitting order");
        softAssert.assertTrue(paymentDonePage.congratulationsMessageIsVisible(), "Congratulations message should be displayed after submitting order");

        paymentDonePage.clickContinueButton();
        wait.until(ExpectedConditions.urlToBe(baseURL + "/"));

        softAssert.assertEquals(driver.getCurrentUrl(), baseURL + "/", "URL should redirect to home page URL after clicking continue on payment done page");

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
