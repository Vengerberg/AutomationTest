package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BrandPage;
import pages.HomePage;

public class TestBrandFilter extends BaseTest {

    private HomePage homePage;
    private BrandPage brandPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        brandPage = new BrandPage(driver, actions, wait);
    }

    @Test
    public void testFilterByBrand() {
    }
}
