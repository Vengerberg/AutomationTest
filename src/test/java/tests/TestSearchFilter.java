package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
        driver.navigate().to(baseURL + productsPage.getRoute());
        wait.until(ExpectedConditions.urlToBe(baseURL + productsPage.getRoute()));

        String searchTerm = "Blue";
        productsPage.search(searchTerm);

        Assert.assertTrue(productsPage.productsContainSearchTerm(searchTerm));
    }
}
