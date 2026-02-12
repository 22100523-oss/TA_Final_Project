package tests.ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void removeFromCartTest() {
        CartPage cartPage = new CartPage(driver);
        cartPage.removeFromCart();
    }
}