package tests.ui;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("UI Testing")
@Feature("Product Search")
public class SearchProductTest extends BaseTest {

    @Test(description = "Search Product")
    @Story("Search Functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void searchProductUI() {
        driver.get("https://automationexercise.com/products");

        driver.findElement(By.id("search_product")).sendKeys("Blue Top");
        driver.findElement(By.id("submit_search")).click();

        String resultText = driver.findElement(By.cssSelector(".features_items h2")).getText();
        System.out.println("Search Results Title: " + resultText);
    }
}