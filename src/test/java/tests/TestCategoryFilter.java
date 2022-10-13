package tests;

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
    }
}
