package tests;

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

    @Test
    public void testWriteReview() throws InterruptedException {
    }
}
