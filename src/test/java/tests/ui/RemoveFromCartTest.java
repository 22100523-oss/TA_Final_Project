package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.CartPage;

public class RemoveFromCartTest {

    private WebDriver driver;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cartPage = new CartPage(driver);
        cartPage.login("giotchey@gmail.com", "password123");
    }

    @Test
    public void removeFromCartTest() {
        int productId = 2;
        cartPage.removeFromCart(productId);
        cartPage.addToCart(productId);
        cartPage.removeFromCart(productId);
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}