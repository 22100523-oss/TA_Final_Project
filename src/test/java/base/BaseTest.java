package base;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {
        // Setup for UI tests (only if driver is needed)
        setupUIDriver();

        // Setup for API tests
        setupAPISpec();
    }

    private void setupUIDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    private void setupAPISpec() {
        RestAssured.baseURI = "https://automationexercise.com";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com")
                .setContentType("application/x-www-form-urlencoded")
                .build();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        // Take screenshot on UI test failure
        if (ITestResult.FAILURE == result.getStatus() && driver != null) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failed Test Screenshot",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        "png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}