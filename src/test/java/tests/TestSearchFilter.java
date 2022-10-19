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

    @Test(dataProvider = "product-provider")
    public void testFilterBySearch(String productName) {
        driver.navigate().to(baseURL + productsPage.getRoute());
        wait.until(ExpectedConditions.urlToBe(baseURL + productsPage.getRoute()));

        productsPage.search(productName);

        Assert.assertTrue(productsPage.productsContainSearchTerm(productName), "Displayed product count after search filter should be less than home page product count");
    }
}
