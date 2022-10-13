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

    @Test
    public void testFilterByBrand() {
        String[] input = new String[]{"Polo", "Blue Top"};

        int homePageProductCount = homePage.getProductCount();

        driver.navigate().to(baseURL + brandPage.getRouteForBrand(input[0]));
        wait.until(ExpectedConditions.urlToBe(baseURL + brandPage.getRouteForBrand(input[0])));

        int brandPageProductCount = brandPage.getProductCount();

        Assert.assertTrue(brandPageProductCount < homePageProductCount);
    }
}

