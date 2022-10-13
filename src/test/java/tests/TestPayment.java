package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;


public class TestPayment extends BaseTest {

    private HomePage homePage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        productsPage = new ProductsPage(driver, actions, wait);
        cartPage = new CartPage(driver, actions, wait);
        checkoutPage = new CheckoutPage(driver, actions, wait);
        paymentPage = new PaymentPage(driver, actions, wait);
    }

    @Test
    public void testPayForCart() {
    }
}
