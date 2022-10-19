package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ProductDetailsPage;

public class TestProductDetailsDisplayed extends BaseTest {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        productDetailsPage = new ProductDetailsPage(driver, actions, wait);
    }

    @Test(dataProvider = "product-provider")
    public void testCorrectProductDisplayed(String productName) {
        SoftAssert softAssert = new SoftAssert();

        String productId = homePage.getProductId(productName);
        String productCost = homePage.getProductCost(productName);

        driver.navigate().to(baseURL + productDetailsPage.getRouteForProduct(productId));
        wait.until(ExpectedConditions.urlToBe(baseURL + productDetailsPage.getRouteForProduct(productId)));

        softAssert.assertEquals(productDetailsPage.getProductName(), productName, "Selected product's name should be displayed on product details page");
        softAssert.assertEquals(productDetailsPage.getProductCost(), productCost, "Selected product's cost should be displayed on product details page");
        softAssert.assertAll();
    }
}
