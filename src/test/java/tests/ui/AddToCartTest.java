package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.CartPage;
import pages.HomePage;

public class AddToCartTest {

    private WebDriver driver;
    private CartPage cartPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        homePage.openHomePage();
    }

    @Test
    public void addToCartTest() {
        cartPage.addToCart(2);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}