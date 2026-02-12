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
public class RemoveFromCartTest extends BaseTest {

    @Test(description = "Remove Product from Cart")
    @Story("Cart Management")
    @Description("Test Case: Remove a product from shopping cart")
    @Severity(SeverityLevel.NORMAL)
    public void removeFromCartTest() {
        driver.get("https://automationexercise.com/view_cart");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".cart_quantity_delete")
        )).click();

        String cartInfo = driver.findElement(By.cssSelector(".cart_info")).getText();
        System.out.println("✓ Cart after remove: " + cartInfo);
    }
}