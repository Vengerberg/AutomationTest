package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class TestAddProduct extends BaseTest {

    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        productsPage = new ProductsPage(driver, actions, wait);
        productDetailsPage = new ProductDetailsPage(driver, actions, wait);
        cartPage = new CartPage(driver, actions, wait);
    }

    @Test
    public void testAddProductFromHomePage() {
    }

    @Test
    public void testAddProductFromProductPage() {
    }

    @Test
    public void testAddProductFromProductDetailsPage() {
    }

    @Test
    public void testAddMultipleQuantityFromProductDetailsPage() {
    }
}
