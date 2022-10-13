package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

public class TestSearchFilter extends BaseTest {

    private HomePage homePage;
    private ProductsPage productsPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        productsPage = new ProductsPage(driver, actions, wait);
    }

    @Test
    public void testFilterBySearch() {
    }
}
