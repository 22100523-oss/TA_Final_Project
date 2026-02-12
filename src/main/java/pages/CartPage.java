package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private By loginEmail = By.cssSelector("input[data-qa='login-email']");
    private By loginPassword = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By continueShoppingButton = By.cssSelector("button.close-modal, .modal_close");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        openUrl("https://automationexercise.com/login");
        type(loginEmail, email);
        type(loginPassword, password);
        click(loginButton);
        wait.until(ExpectedConditions.urlContains("automationexercise.com"));
    }

    public void addToCart(int productId) {
        openUrl("https://automationexercise.com/");
        By addButton = By.cssSelector("a[data-product-id='" + productId + "'].add-to-cart");
        click(addButton);

        try {
            WebElement modalClose = wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
            modalClose.click();
            wait.until(ExpectedConditions.invisibilityOf(modalClose));
        } catch (Exception e) {
        }
    }

    public void removeFromCart(int productId) {
        openUrl("https://automationexercise.com/view_cart");
        By deleteButton = By.cssSelector("a.cart_quantity_delete[data-product-id='" + productId + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        click(deleteButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteButton));
    }
}