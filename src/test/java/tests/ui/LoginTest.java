package tests.ui;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("UI Testing")
@Feature("User Authentication")
public class LoginTest extends BaseTest {

    @Test(description = "User Login Test")
    @Story("User Login")
    @Description("Test Case: Login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {
        driver.get("https://automationexercise.com/login");

        driver.findElement(By.name("email")).sendKeys("giotchey@gmail.com");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Verify login success
        String userInfo = driver.findElement(By.cssSelector(".user-info")).getText();
        System.out.println("✓ Logged in as: " + userInfo);
    }
}