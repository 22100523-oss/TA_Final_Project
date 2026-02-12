package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By signupNameInput = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void register(String name, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupNameInput)).sendKeys(name);
        driver.findElement(signupEmailInput).sendKeys(email);
        driver.findElement(signupButton).click();
    }
}