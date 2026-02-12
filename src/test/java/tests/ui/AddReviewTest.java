package tests.ui;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("UI Testing")
@Feature("Product Review")
public class AddReviewTest extends BaseTest {

    @Test(description = "Add Review on Product")
    @Story("Product Review Submission")
    @Severity(SeverityLevel.CRITICAL)
    public void addReviewUI() {
        driver.get("https://automationexercise.com/products");

        driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();
        driver.findElement(By.cssSelector("a[href='#reviews']")).click();

        driver.findElement(By.id("name")).sendKeys("Test User");
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("review")).sendKeys("Great product!");

        driver.findElement(By.id("button-review")).click();

        String successMsg = driver.findElement(By.cssSelector(".alert-success span")).getText();
        System.out.println("Review Submission Message: " + successMsg);
    }
}