package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;

public class TestWriteReview extends BaseTest {

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        productDetailsPage = new ProductDetailsPage(driver, actions, wait);
    }

    @Test(dataProvider = "random-product-provider")
    public void testWriteReview(String productName) {
        String productId = homePage.getProductId(productName);

        driver.navigate().to(baseURL + productDetailsPage.getRouteForProduct(productId));
        wait.until(ExpectedConditions.urlToBe(baseURL + productDetailsPage.getRouteForProduct(productId)));

        String comment = faker.lorem().fixedString(75);

        productDetailsPage.writeReview(firstName + " " + lastName, email, comment);
        Assert.assertTrue(productDetailsPage.reviewSuccessMessageIsVisible());
    }
}
