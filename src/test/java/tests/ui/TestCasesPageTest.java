package tests.ui;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("UI Testing")
@Feature("Test Cases Page")
public class TestCasesPageTest extends BaseTest {

    @Test(description = "Verify Test Cases Page")
    @Story("Test Cases Page Validation")
    @Severity(SeverityLevel.NORMAL)
    public void testCasesPageUI() {
        driver.get("https://automationexercise.com/test_cases");

        String pageTitle = driver.findElement(By.cssSelector("h2.title.text-center")).getText();
        System.out.println("Test Cases Page Title: " + pageTitle);
    }
}