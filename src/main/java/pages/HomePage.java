package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartLink;

    public void clickLogout() {
        logoutButton.click();
    }

    public void openCart() {
        cartLink.click();
    }
}