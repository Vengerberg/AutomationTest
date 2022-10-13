package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;

public class TestCategoryFilter extends BaseTest {

    private HomePage homePage;
    private CategoryPage categoryPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        categoryPage = new CategoryPage(driver, actions, wait);
    }

    @Test
    public void testFilterByCategory() {
        String[] input = new String[]{"Women", "Tops", "Blue Top"};

        int homePageProductCount = homePage.getProductCount();

        String categoryId = homePage.getCategoryId(input[0], input[1]);

        driver.navigate().to(baseURL + categoryPage.getRouteForCategory(categoryId));
        wait.until(ExpectedConditions.urlToBe(baseURL + categoryPage.getRouteForCategory(categoryId)));

        int categoryPageProductCount = categoryPage.getProductCount();

        Assert.assertTrue(categoryPageProductCount < homePageProductCount);
    }
}
