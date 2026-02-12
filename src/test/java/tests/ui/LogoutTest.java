package tests.ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@example.com", "password123");

        HomePage homePage = new HomePage(driver);
        homePage.clickLogout();
    }
}