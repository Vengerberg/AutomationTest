package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.github.javafaker.Faker;
import util.ExcelReader;


import java.io.File;
import java.time.Duration;

public abstract class BaseTest {

    protected static WebDriver driver;
    protected static Actions actions;
    protected static WebDriverWait wait;
    protected static Faker faker;
    protected static String email;
    protected static String password;
    protected static String firstName;
    protected static String lastName;
    protected static String title;
    protected static String phone;
    protected static String birthDay;
    protected static String birthMonth;
    protected static String birthYear;

    // address
    protected static String address;
    protected static String country;
    protected static String city;
    protected static String state;
    protected static String zip;

    // card details
    protected static String creditCard;
    protected static String cvc;
    protected static String expirationMonth;
    protected static String expirationYear;

    protected static String baseURL = "https://www.automationexercise.com";

    protected static SoftAssert softAssert;
    protected static ExcelReader data;

    // Before/After Setup/Cleanup
    @BeforeSuite
    public void initializeVariables() {
        // https://bonigarcia.dev/webdrivermanager/#setup <- Remove need for System properties/manual download of ChromeDriver
        WebDriverManager.chromedriver().setup();

        // https://chromedriver.chromium.org/extensions <-- Installing extensions reference
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("extensions/ublock.crx"));

        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        faker = new Faker();

        email = faker.bothify("???????9#@gmail.com");
        password = faker.bothify("????????###");
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        phone = faker.phoneNumber().cellPhone();

        if((int)(Math.random()*10)+1 > 5) {
            title = "Mr";
        } else {
            title = "Mrs";
        }

        birthDay = faker.numerify("#");
        birthMonth = faker.numerify("#");
        birthYear = faker.numerify("19##");

        address = faker.address().streetAddress();
        country = "United States";
        city = faker.address().city();
        state = faker.address().state();
        zip = faker.address().zipCode();

        creditCard = faker.numerify("################");
        cvc = faker.numerify("###");
        expirationMonth = faker.numerify("##");
        expirationYear = faker.numerify("####");

        data = new ExcelReader("AutomationTestData.xlsx");

        softAssert = new SoftAssert();

        // load products
        // load brand
        // load category
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void close() {
        // check for soft assert errors
        softAssert.assertAll();
        driver.close();
        driver.quit();
    }

    @DataProvider(name = "product-provider")
    public Object[][] getProducts() {
        return data.getProducts();
    }

    @DataProvider(name = "multi-product-provider")
    public Object[][] getMultiProducts() {
        return data.getMultiProducts();
    }

    @DataProvider(name = "random-product-provider")
    public Object[][] getRandomProduct() {
        String[][] products = data.getProducts();
        int randomProduct = (int) (Math.random()*products.length);
        return new String[][]{products[randomProduct]};
    }

    @DataProvider(name = "brand-provider")
    public Object[][] getBrands() {
        return data.getBrands();
    }

    @DataProvider(name = "category-provider")
    public Object[][] getCategories() {
        return data.getCategories();
    }
}


