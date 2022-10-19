package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class TestRemoveProduct extends BaseTest {

    private HomePage homePage;
    private CartPage cartPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        cartPage = new CartPage(driver, actions, wait);
    }

    @Test(dataProvider = "random-product-provider")
    public void testRemoveProductFromCart(String productName) {
        homePage.addProduct(productName);
        homePage.clickViewCartFromPopup();
        wait.until(ExpectedConditions.urlToBe(baseURL + cartPage.getRoute()));

        int startingCartSize = cartPage.getCartSize();
        cartPage.emptyCart();
        cartPage.waitForEmptyMessage();

        Assert.assertTrue(cartPage.getCartSize() < startingCartSize, "Cart size should be smaller after removing product");
    }
}
