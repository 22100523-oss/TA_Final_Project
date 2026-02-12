package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscriptionPage extends BasePage {

    private By emailInput = By.id("susbscribe_email");
    private By subscribeButton = By.id("subscribe");

    public SubscriptionPage(WebDriver driver) {
        super(driver);
    }

    public void subscribe(String email) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(subscribeButton).click();
    }
}