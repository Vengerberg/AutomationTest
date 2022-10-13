package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestSignup extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private DeletePage deletePage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;

    @BeforeClass
    public void createPages() {
        homePage = new HomePage(driver, actions, wait);
        loginPage = new LoginPage(driver, actions, wait);
        deletePage = new DeletePage(driver, actions, wait);
        signupPage = new SignupPage(driver, actions, wait);
        accountCreatedPage = new AccountCreatedPage(driver, actions, wait);
    }

    @Test
    public void TestRegisterUser() {
    }

    @Test
    public void TestAlreadyRegisteredUser() {
    }

    @Test
    public void TestRegisterDeletedUser() {
    }
}
