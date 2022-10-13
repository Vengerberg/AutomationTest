package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DeletePage;
import pages.HomePage;

public class TestDeleteAccount extends BaseTest {

    private HomePage homePage;
    private DeletePage deletePage;


    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        deletePage = new DeletePage(driver, actions, wait);
    }

    @Test
    public void testDeleteAccount() {

    }
}
