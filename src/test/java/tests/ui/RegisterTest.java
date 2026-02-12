package tests.ui;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerTest() {
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Giorgi");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("giorgi@test.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
    }
}