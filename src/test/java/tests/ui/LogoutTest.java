package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.get("https://automationexercise.com/");
    }

    @Test
    public void logoutTest() {
        loginPage.goToLoginPage();
        loginPage.login("giotchey@gmail.com", "password123");
        homePage.logout();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}