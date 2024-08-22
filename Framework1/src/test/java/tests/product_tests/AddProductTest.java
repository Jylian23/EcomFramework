package tests.product_tests;

import base.BaseTestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class AddProductTest extends BaseTestUtilities {

    @Test
    public void addProductToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.logIn();

        productPage.addItemToTheCart(0);
        Assert.assertEquals(productPage.getItemCountInCart(), 1);
    }
}
