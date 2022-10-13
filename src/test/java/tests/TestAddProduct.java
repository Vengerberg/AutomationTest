package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        homePage.addProduct("Blue Top");
        Assert.assertTrue(homePage.productAddedPopupVisible());
    }

    @Test
    public void testAddProductFromProductPage() {
        driver.navigate().to(baseURL + productsPage.getRoute());
        wait.until(ExpectedConditions.urlToBe(baseURL + productsPage.getRoute()));
        productsPage.addProduct("Blue Top");
        Assert.assertTrue(productsPage.productAddedPopupVisible());
    }

    @Test
    public void testAddProductFromProductDetailsPage() {
        String productId = homePage.getProductId("Blue Top");
        driver.navigate().to(baseURL + productDetailsPage.getRouteForProduct(productId));
        wait.until(ExpectedConditions.urlToBe(baseURL + productDetailsPage.getRouteForProduct(productId)));
        productDetailsPage.addProduct();
        Assert.assertTrue(productDetailsPage.productAddedPopupVisible());
    }

    @Test
    public void testAddMultipleQuantityFromProductDetailsPage() {
        cartPage.emptyCart();

        int quantity = 3;
        String productId = homePage.getProductId("Blue Top");
        driver.navigate().to(baseURL + productDetailsPage.getRouteForProduct(productId));
        wait.until(ExpectedConditions.urlToBe(baseURL + productDetailsPage.getRouteForProduct(productId)));

        productDetailsPage.setQuantity(quantity);
        productDetailsPage.addProduct();

        Assert.assertTrue(productDetailsPage.productAddedPopupVisible());

        productDetailsPage.clickViewCartFromPopup();
        wait.until(ExpectedConditions.urlToBe(baseURL + cartPage.getRoute()));

        Assert.assertTrue(cartPage.getQuantityOfProduct("").equals(Integer.toString(quantity)));
    }

    @AfterMethod
    public void clearCarts() {
        driver.navigate().to(baseURL + cartPage.getRoute());
        cartPage.emptyCart();
    }
}
