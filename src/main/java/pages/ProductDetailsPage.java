package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private By reviewTab = By.cssSelector("a[href='#reviews']");
    private By nameInput = By.id("name");
    private By emailInput = By.id("email");
    private By reviewInput = By.id("review");
    private By submitReviewBtn = By.id("button-review");
    private By successMsg = By.cssSelector(".alert-success span");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void openReviewTab() {
        driver.findElement(reviewTab).click();
    }

    public void writeReview(String name, String email, String review) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(reviewInput).sendKeys(review);
    }

    public void submitReview() {
        driver.findElement(submitReviewBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}