package tests.checkout_tests;

import base.BaseTestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class BuyProductsTest extends BaseTestUtilities {

    @Test
    public void buyProducts(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.logIn();

        productPage.addItemToTheCart(0);
        productPage.addItemToTheCart(2);
        productPage.addItemToTheCart(4);
        productPage.shoppingCartBtn.click();

        YourCartPage yourCart = new YourCartPage(driver);
        yourCart.checkoutBtn.click();

        InformationPage infPage = new InformationPage(driver);
        OverviewPage overviewPage = infPage.checkOut("Uli","Mutafchiiski","1510");
        overviewPage.finishBtn.click();

        CheckoutCompletePage checkoutPage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutPage.isOrderSuccessful());
    }
}
