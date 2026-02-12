package tests.ui;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("UI Testing")
@Feature("Subscription")
public class SubscriptionTest extends BaseTest {

    @Test(description = "Subscribe to Newsletter")
    @Story("Footer Subscription")
    @Severity(SeverityLevel.NORMAL)
    public void subscriptionUI() {
        driver.get("https://automationexercise.com/");

        driver.findElement(By.id("susbscribe_email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("subscribe")).click();

        System.out.println("Subscription submitted with test email");
    }
}