package tests.ui;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("UI Testing")
@Feature("Shopping Cart")
public class AddToCartTest extends BaseTest {

    @Test(description = "Add Product to Cart")
    @Story("Cart Management")
    @Description("Test Case: Add a product to shopping cart")
    @Severity(SeverityLevel.CRITICAL)
    public void addToCartTest() {
        driver.get("https://automationexercise.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/product_details/1'] ~ .add-to-cart")
        )).click();

        // Optional: Assert cart info
        String cartInfo = driver.findElement(By.cssSelector(".cart-info")).getText();
        System.out.println("✓ Cart Info: " + cartInfo);
    }
}