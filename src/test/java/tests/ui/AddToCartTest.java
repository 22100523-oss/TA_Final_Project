package tests.ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartTest() {
        CartPage cartPage = new CartPage(driver);
        cartPage.addToCart();
    }
}