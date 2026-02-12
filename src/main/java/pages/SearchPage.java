package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By resultsTitle = By.cssSelector(".features_items h2");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public String getResultsTitle() {
        return driver.findElement(resultsTitle).getText();
    }
}