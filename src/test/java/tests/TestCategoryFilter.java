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

    @Test(dataProvider = "category-provider")
    public void testFilterByCategory(String group, String type) {
        int homePageProductCount = homePage.getProductCount();

        String categoryId = homePage.getCategoryId(group, type);

        driver.navigate().to(baseURL + categoryPage.getRouteForCategory(categoryId));
        wait.until(ExpectedConditions.urlToBe(baseURL + categoryPage.getRouteForCategory(categoryId)));

        int categoryPageProductCount = categoryPage.getProductCount();

        Assert.assertTrue(categoryPageProductCount < homePageProductCount, "Displayed product count after category filter should be less than home page product count");
    }
}
