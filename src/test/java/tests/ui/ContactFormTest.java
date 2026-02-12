package tests.ui;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("UI Testing")
@Feature("Contact Form")
public class ContactFormTest extends BaseTest {

    @Test(description = "Submit Contact Form")
    @Story("Contact Form Submission")
    @Severity(SeverityLevel.CRITICAL)
    public void contactFormUI() {
        driver.get("https://automationexercise.com/contact_us");

        driver.findElement(By.name("name")).sendKeys("Test User");
        driver.findElement(By.name("email")).sendKeys("testuser@example.com");
        driver.findElement(By.name("subject")).sendKeys("Test Subject");
        driver.findElement(By.name("message")).sendKeys("This is a test message.");

        driver.findElement(By.name("submit")).click();

        String successMsg = driver.findElement(By.cssSelector(".status.alert-success")).getText();
        System.out.println("Contact Form Submission Message: " + successMsg);
    }
}