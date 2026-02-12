package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        driver.get("https://automationexercise.com/");
    }

    @Test
    public void validLoginTest() {
        loginPage.goToLoginPage();
        loginPage.login("giotchey@gmail.com", "password123");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}