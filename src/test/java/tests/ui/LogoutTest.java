package tests.ui;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("UI Testing")
@Feature("User Authentication")
public class LogoutTest extends BaseTest {

    @Test(description = "User Logout Test")
    @Story("User Logout")
    @Description("Test Case: Logout from user account")
    @Severity(SeverityLevel.NORMAL)
    public void logoutTest() {
        driver.get("https://automationexercise.com/logout");

        // Verify logout
        String logoutMsg = driver.findElement(By.cssSelector(".logout-message")).getText();
        System.out.println("✓ Logout message: " + logoutMsg);
    }
}