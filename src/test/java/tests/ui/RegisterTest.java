package tests.ui;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    @Test
    public void registerTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Signup / Login')]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='signup-name']"))).sendKeys("Giorgi");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("giorgi@test.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        wait.until(ExpectedConditions.urlContains("signup"));
    }
}