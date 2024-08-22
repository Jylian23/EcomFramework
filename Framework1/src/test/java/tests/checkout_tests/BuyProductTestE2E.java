package tests.checkout_tests;

import base.BaseTestUtilities;
import org.testng.annotations.Test;
import pages.*;

public class BuyProductTestE2E extends BaseTestUtilities {

    @Test
    public void buyProductE2E(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.logIn();
        softAssert.assertTrue(correctPageIsLoaded(PRODUCT_PAGE_URL));
        softAssert.assertFalse(productPage.shoppingCartBadgeIsDisplayed());

        productPage.addItemToTheCart(1);
        softAssert.assertEquals(productPage.getItemCountInCart(),1);

        productPage.shoppingCartBtn.click();
        softAssert.assertTrue(correctPageIsLoaded(YOUR_CART_PAGE_URL));

        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.checkoutBtn.click();
        softAssert.assertTrue(correctPageIsLoaded(YOUR_INFO_PAGE_URL));

        InformationPage infoPage = new InformationPage(driver);
        OverviewPage overviewPage = infoPage.checkOut("Marto","Asenov","1010");
        softAssert.assertTrue(correctPageIsLoaded(OVERVIEW_PAGE_URL));

        overviewPage.finishBtn.click();
        softAssert.assertTrue(correctPageIsLoaded(CHECKOUT_COMPLETE_PAGE_URL));

        CheckoutCompletePage checkoutPage = new CheckoutCompletePage(driver);
        softAssert.assertTrue(checkoutPage.isOrderSuccessful());

        checkoutPage.backHomeBtn.click();
        softAssert.assertTrue(correctPageIsLoaded(PRODUCT_PAGE_URL));

        productPage.LogOut();
        softAssert.assertTrue(correctPageIsLoaded(BASE_LOGIN_PAGE_URL));

        softAssert.assertAll();
    }
}
