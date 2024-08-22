package tests.product_tests;

import base.BaseTestUtilities;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class RemoveProductTest extends BaseTestUtilities {

    @Test
    public void removeProductFromCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.logIn();
        softAssert.assertTrue(correctPageIsLoaded(PRODUCT_PAGE_URL));

        productPage.addItemToTheCart(3);
        softAssert.assertEquals(productPage.getItemCountInCart(),1);

        productPage.removeItemFromTheCart(3);
        softAssert.assertFalse(productPage.shoppingCartBadgeIsDisplayed());

        softAssert.assertAll();
    }


}
