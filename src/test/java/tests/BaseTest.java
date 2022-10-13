package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

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

    protected static String baseURL = "https://www.automationexercise.com/";


    // Before/After Setup/Cleanup

    @BeforeSuite
    public void initializeVariables() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Windows\\chromedriver_win32\\chromedriver.exe");

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

    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void close() {
        // check for soft assert errors
        driver.close();
        driver.quit();
    }
}

