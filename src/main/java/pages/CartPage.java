package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CartPage extends BasePage {

    private By loginEmail = By.cssSelector("input[data-qa='login-email']");
    private By loginPassword = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        openUrl("https://automationexercise.com/login");
        type(loginEmail, email);
        type(loginPassword, password);
        click(loginButton);
    }

    public void addToCart(int productId) {
        openUrl("https://automationexercise.com/");
        click(By.cssSelector("a[data-product-id='" + productId + "'].add-to-cart"));
        By modal = By.id("cartModal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        click(By.cssSelector("#cartModal .modal-footer .btn"));
    }

    public void removeFromCart(int productId) {
        openUrl("https://automationexercise.com/view_cart");
        By deleteButton = By.cssSelector("a.cart_quantity_delete[data-product-id='" + productId + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        click(deleteButton);
    }
}