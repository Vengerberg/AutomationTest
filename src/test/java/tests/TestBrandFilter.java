package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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

    @Test(dataProvider = "brand-provider")
    public void testFilterByBrand(String productName) {
        int homePageProductCount = homePage.getProductCount();

        homePage.clickBrandFilterButton(productName);
        wait.until(ExpectedConditions.urlToBe(baseURL + brandPage.getRouteForBrand(productName)));

        int brandPageProductCount = brandPage.getProductCount();

        Assert.assertTrue(brandPageProductCount < homePageProductCount, "Displayed product count after brand filter should be less than home page product count");
    }
}
