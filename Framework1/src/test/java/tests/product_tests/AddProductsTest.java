package tests.product_tests;

import base.BaseTestUtilities;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class AddProductsTest extends BaseTestUtilities {

    @Test
    public void addProductsToCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.logIn();

        for (int i = 0; i < productPage.productsList.size()-1; i++) {
            productPage.addItemToTheCart(i);
            softAssert.assertEquals(productPage.getItemCountInCart(),i+1);
        }

        softAssert.assertEquals(productPage.getItemCountInCart(),5);
        softAssert.assertAll();
    }
}
