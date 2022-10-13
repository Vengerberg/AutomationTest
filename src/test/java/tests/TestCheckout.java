package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
    }

    @Test
    public void testCheckoutNotLoggedIn() {
    }

    @Test
    public void testCheckoutLoggedIn() {
    }

    @Test
    public void testCorrectDetailsDisplayed() {
    }
}
