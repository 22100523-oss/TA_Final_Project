package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(text(),'Remove')]")
    private WebElement removeButton;

    public void addToCart() {
        addToCartButton.click();
    }

    public void removeFromCart() {
        removeButton.click();
    }
}