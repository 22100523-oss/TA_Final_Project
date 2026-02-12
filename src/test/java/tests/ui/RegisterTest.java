package tests.ui;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("UI Testing")
@Feature("User Registration")
public class RegisterTest extends BaseTest {

    @Test(description = "User Registration Test")
    @Story("User Registration")
    @Description("Test Case: Register a new user account")
    @Severity(SeverityLevel.CRITICAL)
    public void registerTest() {
        driver.get("https://automationexercise.com/signup");

        driver.findElement(By.name("name")).sendKeys("Giorgi Tcheishvili");
        driver.findElement(By.name("email")).sendKeys("giotchey@gmail.com");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Assert registration success message
        String message = driver.findElement(By.cssSelector(".signup-success")).getText();
        System.out.println("✓ Register message: " + message);
    }
}