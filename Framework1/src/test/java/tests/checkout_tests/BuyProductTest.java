package tests.checkout_tests;

import base.BaseTestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class BuyProductTest extends BaseTestUtilities {

    @Test
    public void buyProduct(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.logIn();

        productPage.addItemToTheCart(0);
        productPage.shoppingCartBtn.click();

        YourCartPage cartPage = new YourCartPage(driver);
        cartPage.checkoutBtn.click();

        InformationPage informationPage = new InformationPage(driver);
        OverviewPage overviewPage = informationPage.checkOut("Koko","Asenov","1010");
        overviewPage.finishBtn.click();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutCompletePage.isOrderSuccessful());
    }
}
