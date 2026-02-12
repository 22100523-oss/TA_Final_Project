package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    private By pageTitle = By.cssSelector("h2.title.text-center");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitleText() {
        return driver.findElement(pageTitle).getText();
    }
}