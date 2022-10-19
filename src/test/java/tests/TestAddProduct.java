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

    @Test(dataProvider = "product-provider")
    public void testAddProductFromHomePage(String productName) {
        homePage.addProduct(productName);
        Assert.assertTrue(homePage.productAddedPopupVisible(), "Popup should show that product was added to cart from home page");
    }

    @Test(dataProvider = "product-provider")
    public void testAddProductFromProductPage(String productName) {
        driver.navigate().to(baseURL + productsPage.getRoute());
        wait.until(ExpectedConditions.urlToBe(baseURL + productsPage.getRoute()));
        productsPage.addProduct(productName);
        Assert.assertTrue(productsPage.productAddedPopupVisible(), "Popup should show that product was added to cart from product page");
    }

    @Test(dataProvider = "product-provider")
    public void testAddProductFromProductDetailsPage(String productName) {
        String productId = homePage.getProductId(productName);
        driver.navigate().to(baseURL + productDetailsPage.getRouteForProduct(productId));
        wait.until(ExpectedConditions.urlToBe(baseURL + productDetailsPage.getRouteForProduct(productId)));
        productDetailsPage.addProduct();
        Assert.assertTrue(productDetailsPage.productAddedPopupVisible(), "Popup should show that product was added to cart from product details page");
    }

    @Test(dataProvider = "product-provider")
    public void testAddMultipleQuantityFromProductDetailsPage(String productName) {
        cartPage.emptyCart();

        int quantity = (int) (Math.random()*10)+1;
        String productId = homePage.getProductId(productName);
        driver.navigate().to(baseURL + productDetailsPage.getRouteForProduct(productId));
        wait.until(ExpectedConditions.urlToBe(baseURL + productDetailsPage.getRouteForProduct(productId)));

        productDetailsPage.setQuantity(quantity);
        productDetailsPage.addProduct();

        productDetailsPage.clickViewCartFromPopup();
        wait.until(ExpectedConditions.urlToBe(baseURL + cartPage.getRoute()));

        Assert.assertTrue(cartPage.getQuantityOfProduct(productName).equals(Integer.toString(quantity)), "Quantity of product should be equal to quantity input from product details page");
    }

    @AfterMethod
    public void clearCarts() {
        driver.navigate().to(baseURL + cartPage.getRoute());
        cartPage.emptyCart();
    }
}
