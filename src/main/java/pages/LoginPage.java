package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailInput = By.xpath("//input[@data-qa='login-email']");
    private By passwordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        click(signupLoginLink);
    }

    public void login(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        click(loginButton);
    }
}