package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By logoutLink = By.xpath("//a[@href='/logout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        click(logoutLink);
    }

    public void openHomePage() {
        openUrl("https://automationexercise.com/");
    }
}