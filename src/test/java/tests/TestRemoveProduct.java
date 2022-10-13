package tests;

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

    @Test
    public void testRemoveProductFromCart() {
    }
}
